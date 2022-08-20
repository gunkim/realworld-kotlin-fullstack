package io.github.gunkim.domain

interface StudentRepository {
    fun findById(id: Long): Student
    fun save(student: Student): Student
}