package io.github.gunkim.application.usecase.student

import io.github.gunkim.domain.student.StudentRepository
import io.github.gunkim.domain.student.usecase.ChangeScoreUseCase

class ChangeScoreService(
    private val repository: StudentRepository,
) : ChangeScoreUseCase {
    override fun changeScore(studentId: Long, subjectId: Long, score: Int) {
        val student = repository.findById(studentId)
        student.changeSubjectScore(subjectId, score)
    }
}