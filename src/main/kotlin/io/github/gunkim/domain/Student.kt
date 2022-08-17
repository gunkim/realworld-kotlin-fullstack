package io.github.gunkim.domain

class Student(
    val id: Long? = null,
    var name: String,
    val subjects: MutableList<Subject> = mutableListOf(),
) {
    fun addSubject(subject: Subject) {
        subjects.add(subject)
    }
}