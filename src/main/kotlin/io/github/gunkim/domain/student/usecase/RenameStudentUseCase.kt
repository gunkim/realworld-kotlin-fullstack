package io.github.gunkim.domain.student.usecase

interface RenameStudentUseCase {
    fun renameStudent(id: Long, name: String)
}