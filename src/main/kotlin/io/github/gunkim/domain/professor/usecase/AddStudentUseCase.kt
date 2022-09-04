package io.github.gunkim.domain.professor.usecase

fun interface AddStudentUseCase {
    fun addStudent(professorId: Long, studentName: String)
}