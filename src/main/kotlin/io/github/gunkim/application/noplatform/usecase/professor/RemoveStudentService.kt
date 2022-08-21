package io.github.gunkim.application.noplatform.usecase.professor

import io.github.gunkim.domain.professor.ProfessorRepository
import io.github.gunkim.domain.professor.usecase.RemoveStudentUseCase

class RemoveStudentService(
    private val repository: ProfessorRepository,
) : RemoveStudentUseCase {
    override fun removeStudent(professorId: Long, studentId: Long) {
        val professor = repository.findById(professorId)
        professor.removeStudent(studentId)

        repository.save(professor)
    }
}