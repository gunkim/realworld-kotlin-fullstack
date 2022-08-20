package io.github.gunkim.application.noplatform.usecase.student

import io.github.gunkim.domain.student.Student
import io.github.gunkim.domain.student.StudentRepository
import io.github.gunkim.domain.student.usecase.RenameStudentUseCase

class RenameStudentService(
    private val repository: StudentRepository,
) : RenameStudentUseCase {
    override fun renameStudent(id: Long, name: String) {
        val student: Student = repository.findById(id)
        student.rename(name)

        repository.save(student)
    }
}