package io.github.gunkim.application.noplatform.usecase.professor

import io.github.gunkim.domain.professor.ProfessorRepository
import io.github.gunkim.domain.professor.usecase.RenameProfessorUseCase

class RenameProfessorService(
    private val professorRepository: ProfessorRepository,
) : RenameProfessorUseCase {
    override fun renameProfessor(id: Long, name: String) {
        val professor = professorRepository.findById(id)
        professor.rename(name)

        professorRepository.save(professor)
    }
}