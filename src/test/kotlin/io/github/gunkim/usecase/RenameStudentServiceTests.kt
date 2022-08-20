package io.github.gunkim.usecase

import io.github.gunkim.domain.Student
import io.github.gunkim.persistence.FakeStudentRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RenameStudentServiceTests {
    private val repository = FakeStudentRepository()
    private val sut = RenameStudentService(repository)

    @BeforeEach
    fun setup() {
        repository.save(Student(name = "착한 망주"))
    }

    @Test
    fun `이름을 변경한다`() {
        sut.renameStudent(1, "나쁜 망주")

        val student = repository.findById(1)
        assertThat(student.name).isEqualTo("나쁜 망주")
    }
}