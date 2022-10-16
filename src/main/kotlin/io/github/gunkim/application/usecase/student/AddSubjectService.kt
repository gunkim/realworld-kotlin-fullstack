package io.github.gunkim.application.usecase.student

import io.github.gunkim.domain.student.StudentRepository
import io.github.gunkim.domain.student.Subject
import io.github.gunkim.domain.student.usecase.AddSubjectUseCase

class AddSubjectService(
    private val repository: StudentRepository,
) : AddSubjectUseCase {
    override fun addSubject(id: Long, subject: Subject) {
        val student = repository.findById(id)
        student.addSubject(subject)

        repository.save(student)
    }
}