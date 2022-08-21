package io.github.gunkim.application.noplatform.usecase.student

import io.github.gunkim.application.noplatform.persistence.FakeProfessorRepository
import io.github.gunkim.application.noplatform.usecase.professor.RemoveStudentService
import io.github.gunkim.domain.professor.Professor
import io.github.gunkim.domain.student.Student
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RemoveStudentServiceTests {
    private val repository = FakeProfessorRepository()
    private val sut = RemoveStudentService(repository)

    @BeforeEach
    fun setup() {
        repository.save(
            Professor(
                id = 1,
                name = "짱구",
                students = mutableListOf(
                    Student(
                        id = 1,
                        name = "도라에몽"
                    )
                )
            )
        )
    }

    @Test
    fun `학생을 삭제한다`() {
        sut.removeStudent(1, 1)

        assertThat(repository.findById(1).students).hasSize(0)
    }
}