package io.github.gunkim.application.usecase.student

import io.github.gunkim.application.persistence.FakeStudentRepository
import io.github.gunkim.domain.student.Student
import io.github.gunkim.domain.student.Subject
import io.github.gunkim.domain.student.SubjectType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ChangeScoreServiceTests {
    private val repository = FakeStudentRepository()
    private val sut = ChangeScoreService(repository)

    @BeforeEach
    fun setup() {
        repository.save(
            Student(
                id = 1,
                name = "김학생",
                subjects = listOf(
                    Subject(
                        id = 1,
                        type = SubjectType.Math,
                        score = 12
                    )
                )
            )
        )
    }

    @Test
    fun `점수를 변경한다`() {
        sut.changeScore(1, 1, 100)

        val student = repository.findById(1)
        assertThat(student.subjects).extracting("score").contains(100)
    }
}