package io.github.gunkim.usecase

import io.github.gunkim.domain.ProfessorRepository

fun interface RenameProfessorUseCase {
    fun renameProfessor(id: Long, name: String)
}

class RenameProfessorService(
    private val professorRepository: ProfessorRepository,
) : RenameProfessorUseCase {
    override fun renameProfessor(id: Long, name: String) {
        val professor = professorRepository.findById(id)
        professor.rename(name)

        professorRepository.save(professor)
    }
}