package io.github.gunkim.application.noplatform.persistence

import io.github.gunkim.domain.student.Student
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FakeStudentRepositoryTests {
    private val sut = FakeStudentRepository()

    @BeforeEach
    fun setup() {
        sut.save(Student(name = "김교수"))
    }

    @Test
    fun `식별자로 찾는다`() {
        val student = sut.findById(1)

        assertThat(student.name).isEqualTo("김교수")
    }

    @Test
    fun `식별자로 찾지 못할 경우 예외가 발생한다`() {
        assertThrows<NoSuchElementException> { sut.findById(-1) }
            .apply { assertThat(message).isEqualTo("'-1' 아이디를 가진 학생을 찾을 수 없습니다.") }
    }
}