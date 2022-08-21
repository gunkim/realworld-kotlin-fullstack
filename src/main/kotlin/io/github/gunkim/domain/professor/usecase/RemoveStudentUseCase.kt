package io.github.gunkim.domain.professor.usecase

interface RemoveStudentUseCase {
    fun removeStudent(professorId: Long, studentId: Long)
}
