package io.github.gunkim.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class ProfessorTests {
    @Test
    fun `학생을 제외한다`() {
        val student = Student(name = "홍길동")
        val professor = Professor(name = "김길동", students = mutableListOf(student))
        professor.removeStudent(student)

        assertThat(professor.students).hasSize(0)
    }

    @Test
    fun `학생이 없을 경우 제외할 수 없다`() {
        val professor = Professor(name = "김길동", students = mutableListOf())

        assertThrows<IllegalArgumentException> { professor.removeStudent(Student(name = "히히")) }
            .apply { assertThat(message).isEqualTo("'히히' 학생을 찾을 수 없습니다.") }
    }
}