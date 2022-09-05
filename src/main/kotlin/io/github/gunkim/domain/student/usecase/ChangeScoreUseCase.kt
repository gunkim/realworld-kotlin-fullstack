package io.github.gunkim.domain.student.usecase

interface ChangeScoreUseCase {
    fun changeScore(studentId: Long, subjectId: Long, score: Int)
}
