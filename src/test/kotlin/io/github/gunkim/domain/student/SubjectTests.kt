package io.github.gunkim.domain.student

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class SubjectTests {
    @Test
    fun `음수로는 인스턴스를 생성할 수 없다`() {
        assertThrows<IllegalArgumentException>
        { Subject(type = SubjectType.English, score = -1) }
            .apply { assertThat(message).isEqualTo("점수는 음수가 될 수 없습니다. (score: -1)") }
    }

    @Test
    fun `음수로는 점수를 변경할 수 없다`() {
        val subject = Subject(type = SubjectType.Math, score = 12)

        assertThrows<IllegalArgumentException>() { subject.changeScore(-1) }
            .apply { assertThat(message).isEqualTo("점수는 음수가 될 수 없습니다. (score : -1)") }
    }

    @Test
    fun `점수를 변경한다`() {
        val subject = Subject(type = SubjectType.Math, score = 12)
        subject.changeScore(23)

        assertThat(subject.score).isEqualTo(23)
    }
}