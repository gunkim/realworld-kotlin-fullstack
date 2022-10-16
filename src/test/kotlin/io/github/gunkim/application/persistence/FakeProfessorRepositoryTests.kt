package io.github.gunkim.application.persistence

import io.github.gunkim.domain.professor.Professor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FakeProfessorRepositoryTests {
    private val sut = FakeProfessorRepository()

    @BeforeEach
    fun setup() {
        sut.save(Professor(name = "김교수"))
    }

    @Test
    fun `식별자로 찾는다`() {
        val professor = sut.findById(1)

        assertThat(professor.name).isEqualTo("김교수")
    }

    @Test
    fun `식별자로 찾지 못할 경우 예외가 발생한다`() {
        assertThrows<NoSuchElementException> { sut.findById(-1) }
            .apply { assertThat(message).isEqualTo("'-1' 아이디를 가진 교수를 찾을 수 없습니다.") }
    }
}