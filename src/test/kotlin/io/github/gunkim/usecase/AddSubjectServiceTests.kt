package io.github.gunkim.usecase

import io.github.gunkim.domain.Student
import io.github.gunkim.domain.Subject
import io.github.gunkim.domain.SubjectType
import io.github.gunkim.persistence.FakeStudentRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AddSubjectServiceTests {
    private val repository = FakeStudentRepository()
    private val sut = AddSubjectService(repository)

    @BeforeEach
    fun setup() {
        repository.save(Student(name = "짱구"))
    }

    @Test
    fun `과목을 추가한다`() {
        sut.addSubject(1, Subject(type = SubjectType.Math, score = 12))

        assertThat(repository.findById(1)).isNotNull
    }
}