package io.github.gunkim.usecase

import io.github.gunkim.domain.StudentRepository
import io.github.gunkim.domain.Subject

fun interface AddSubjectUseCase {
    fun addSubject(id: Long, subject: Subject)
}

class AddSubjectService(
    private val repository: StudentRepository,
) : AddSubjectUseCase {
    override fun addSubject(id: Long, subject: Subject) {
        val student = repository.findById(id)
        student.addSubject(subject)

        repository.save(student)
    }
}