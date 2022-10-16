package io.github.gunkim.framework.web

import io.github.gunkim.application.persistence.FakeProfessorRepository
import io.github.gunkim.application.usecase.professor.AddStudentService
import io.github.gunkim.domain.professor.Professor
import io.github.gunkim.framework.plugins.configureSerialization
import io.github.gunkim.framework.web.professor.addStudent
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.testing.*
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.BeforeTest
import kotlin.test.Test

class ProfessorRouteTests {
    private val repository = FakeProfessorRepository()
    private val usecase = AddStudentService(repository)

    @BeforeTest
    fun setup() {
        repository.save(
            Professor(
                id = 1,
                name = "아기공룡 둘리",
            )
        )
    }

    private fun Application.testConfigureRouting() {
        routing {
            addStudent(usecase)
        }
    }

    @Test
    fun test() = testApplication {
        application {
            configureSerialization()
            testConfigureRouting()
        }

        val response = client.post("/v1/professors/1/students") {
            contentType(ContentType.Application.Json)
            setBody(AddStudentRequest("테스트 유저"))
        }
        assertThat(HttpStatusCode.OK).isEqualTo(response.status)
        assertThat(repository.findById(1).students).hasSize(1)
    }

    private data class AddStudentRequest(val studentName: String)
}