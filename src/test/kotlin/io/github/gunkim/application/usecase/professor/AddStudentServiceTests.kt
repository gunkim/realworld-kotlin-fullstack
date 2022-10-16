package io.github.gunkim.application.usecase.professor

import io.github.gunkim.application.persistence.FakeProfessorRepository
import io.github.gunkim.domain.professor.Professor
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class AddStudentServiceTests {
    private val repository = FakeProfessorRepository()

    @Before
    fun setup() {
        repository.save(Professor(name = "둘리"))
    }

    @Test
    fun `학생을 추가한다`() {
        val sut = AddStudentService(repository)

        sut.addStudent(1, "또치")

        val professor = repository.findById(1)
        assertThat(professor.students).hasSize(1)
    }
}