package io.github.gunkim.usecase

import io.github.gunkim.domain.StudentRepository

interface RenameStudentUseCase {
    fun renameStudent(id: Long, name: String)
}

class RenameStudentService(
    private val repository: StudentRepository,
) : RenameStudentUseCase {
    override fun renameStudent(id: Long, name: String) {
        val student = repository.findById(id)
        student.rename(name)

        repository.save(student)
    }
}