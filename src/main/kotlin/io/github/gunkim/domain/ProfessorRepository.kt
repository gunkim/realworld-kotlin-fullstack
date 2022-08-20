package io.github.gunkim.domain

interface ProfessorRepository {
    fun findById(id: Long): Professor
    fun save(professor: Professor): Professor
}