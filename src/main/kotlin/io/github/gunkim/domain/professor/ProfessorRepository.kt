package io.github.gunkim.domain.professor

interface ProfessorRepository {
    fun findById(id: Long): Professor
    fun save(professor: Professor): Professor
}