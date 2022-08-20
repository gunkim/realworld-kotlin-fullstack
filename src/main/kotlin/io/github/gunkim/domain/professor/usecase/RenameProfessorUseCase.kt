package io.github.gunkim.domain.professor.usecase

fun interface RenameProfessorUseCase {
    fun renameProfessor(id: Long, name: String)
}