package io.github.gunkim.application.ktor.web.professor

import io.github.gunkim.domain.professor.usecase.AddStudentUseCase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

fun Route.addStudent(addStudentUseCase: AddStudentUseCase) {
    route("/v1") {
        post("/professors/{professorId}/students") {
            val professorId = call.parameters["professorId"]!!.toLong()
            val studentName: String = call.receive()

            addStudentUseCase.addStudent(professorId, studentName)
        }
    }
}