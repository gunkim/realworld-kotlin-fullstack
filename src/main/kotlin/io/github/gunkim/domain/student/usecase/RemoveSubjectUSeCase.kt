package io.github.gunkim.domain.student.usecase

fun interface RemoveSubjectUSeCase {
    fun removeSubject(studentId: Long, subjectId: Long)
}