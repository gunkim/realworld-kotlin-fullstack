package io.github.gunkim.domain.student.usecase

import io.github.gunkim.domain.student.Subject

fun interface AddSubjectUseCase {
    fun addSubject(id: Long, subject: Subject)
}