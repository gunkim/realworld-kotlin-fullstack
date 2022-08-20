package io.github.gunkim.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class ProfessorTests {
    @Test
    fun `학생을 제외한다`() {
        val student = Student(name = "홍길동")
        val professor = Professor(name = "김길동", students = mutableListOf(student))
            .apply { removeStudent(student) }

        assertThat(professor.students).hasSize(0)
    }

    @Test
    fun `학생이 없을 경우 제외할 수 없다`() {
        val professor = Professor(name = "김길동")

        assertThrows<IllegalArgumentException> { professor.removeStudent(Student(name = "히히")) }
            .apply { assertThat(message).isEqualTo("'히히' 학생을 찾을 수 없습니다.") }
    }

    @Test
    fun `이름을 변경한다`() {
        val professor = Professor(name = "김길동")
            .apply { rename("이길동") }

        assertThat(professor.name).isEqualTo("이길동")
    }

    @Test
    fun `공백 이름으로는 이름을 변경할 수 없다`() {
        val professor = Professor(name = "김길동")

        assertThrows<IllegalArgumentException> { professor.rename("      ") }
            .apply { assertThat(message).isEqualTo("이름을 공백으로 변경할 수 없습니다.") }
    }
}