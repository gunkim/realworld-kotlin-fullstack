package io.github.gunkim.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertAll

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
}