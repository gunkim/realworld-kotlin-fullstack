package io.github.gunkim.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class SubjectTests {
    @Test
    fun `점수를 변경한다`() {
        val subject = Subject(type = SubjectType.Math, score = 12)
        subject.changeScore(23)
        assertThat(subject.score).isEqualTo(23)
    }

    @Test
    fun `음수로는 점수를 변경할 수 없다`() {
        val subject = Subject(type = SubjectType.Math, score = 12)

        assertThrows<IllegalArgumentException>() { subject.changeScore(-1) }
            .apply { assertThat(message).isEqualTo("점수는 음수가 될 수 없습니다. (score : -1)") }
    }
}