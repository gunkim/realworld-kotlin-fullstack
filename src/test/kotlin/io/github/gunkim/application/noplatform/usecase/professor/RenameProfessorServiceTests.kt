package io.github.gunkim.application.noplatform.usecase.professor

import io.github.gunkim.application.noplatform.persistence.FakeProfessorRepository
import io.github.gunkim.domain.professor.Professor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RenameProfessorServiceTests {
    private val repository = FakeProfessorRepository()
    private val sut = RenameProfessorService(repository)

    @BeforeEach
    fun setup() {
        repository.save(Professor(name = "짱구"))
    }

    @Test
    fun `이름을 변경한다`() {
        sut.renameProfessor(1, "아기공룡 둘리")

        val professor = repository.findById(1)
        assertThat(professor.name).isEqualTo("아기공룡 둘리")
    }
}