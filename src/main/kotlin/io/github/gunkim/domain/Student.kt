package io.github.gunkim.domain

class Student(
    val id: Long? = null,
    name: String,
    subjects: MutableList<Subject> = mutableListOf(),
) {
    var name: String = name
        private set

    private val _subjects: MutableList<Subject> = subjects.toMutableList()
    val subjects: List<Subject>
        get() = _subjects

    fun addSubject(subject: Subject) {
        _subjects.add(subject)
    }
}