package io.github.gunkim.application.usecase.student

import io.github.gunkim.domain.student.StudentRepository
import io.github.gunkim.domain.student.usecase.RemoveSubjectUSeCase

class RemoveSubjectService(
    private val repository: StudentRepository,
) : RemoveSubjectUSeCase {
    override fun removeSubject(studentId: Long, subjectId: Long) {
        val student = repository.findById(studentId)
            .apply { removeSubject(subjectId) }
        repository.save(student)
    }
}
