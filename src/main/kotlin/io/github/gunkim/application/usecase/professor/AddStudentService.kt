package io.github.gunkim.application.usecase.professor

import io.github.gunkim.domain.professor.ProfessorRepository
import io.github.gunkim.domain.professor.usecase.AddStudentUseCase
import io.github.gunkim.domain.student.Student

class AddStudentService(
    private val professorRepository: ProfessorRepository,
) : AddStudentUseCase {
    override fun addStudent(professorId: Long, studentName: String) {
        val professor = professorRepository.findById(professorId)
            .apply { addStudent(Student(name = studentName)) }

        professorRepository.save(professor)
    }
}