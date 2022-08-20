package io.github.gunkim.domain

class Professor(
    val id: Long? = null,
    name: String,
    students: MutableList<Student>,
) {
    var name: String = name
        private set

    private val _students: MutableList<Student> = students.toMutableList()
    val students: List<Student>
        get() = _students

    fun removeStudent(student: Student) = require(_students.remove(student)) {
        "'${student.name}' 학생을 찾을 수 없습니다."
    }
}