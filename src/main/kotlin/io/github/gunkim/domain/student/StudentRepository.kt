package io.github.gunkim.domain.student

interface StudentRepository {
    fun findById(id: Long): Student
    fun save(student: Student): Student
}