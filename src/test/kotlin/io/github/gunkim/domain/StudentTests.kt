package io.github.gunkim.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.assertThrows

class StudentTests {
    @Test
    fun `과목을 추가한다`() {
        val student = Student(name = "애기거니")
        val subject = Subject(type = SubjectType.Math, score = 78)

        student.addSubject(subject)

        assertAll(
            { assertThat(student.subjects).hasSize(1) },
            { assertThat(student.subjects[0].type).isEqualTo(SubjectType.Math) },
            { assertThat(student.subjects[0].score).isEqualTo(78) }
        )
    }

    @Test
    fun `이름을 변경한다`() {
        val student = Student(name = "애기거니")
        student.rename("성인거니")

        assertThat(student.name).isEqualTo("성인거니")
    }

    @Test
    fun `공백 이름으로는 이름을 변경할 수 없다`() {
        val student = Student(name = "애기거니")

        assertThrows<IllegalArgumentException> { student.rename("      ") }
            .apply { assertThat(message).isEqualTo("이름을 공백으로 변경할 수 없습니다.") }
    }
}