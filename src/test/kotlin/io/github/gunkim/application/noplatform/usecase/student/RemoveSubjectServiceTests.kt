package io.github.gunkim.application.noplatform.usecase.student

import io.github.gunkim.application.noplatform.persistence.FakeStudentRepository
import io.github.gunkim.domain.student.Student
import io.github.gunkim.domain.student.Subject
import io.github.gunkim.domain.student.SubjectType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RemoveSubjectServiceTests {
    private val repository = FakeStudentRepository()
    private val sut = RemoveSubjectService(repository)

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
                        score = 92
                    )
                )
            )
        )
    }

    @Test
    fun `과목을 제거한다`() {
        sut.removeSubject(1, 1)

        val student = repository.findById(1)
        assertThat(student.subjects).hasSize(0)
    }
}