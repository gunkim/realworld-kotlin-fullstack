package io.github.gunkim.domain.professor

import io.github.gunkim.domain.student.Student

class Professor(
    val id: Long? = null,
    name: String,
    students: MutableList<Student> = mutableListOf(),
) {
    var name: String = name
        private set

    private val _students: MutableList<Student> = students.toMutableList()
    val students: List<Student>
        get() = _students


    fun removeStudent(studentId: Long) {
        val student = _students.firstOrNull { it.id == studentId }
            ?: throw IllegalArgumentException("아이디가 '${studentId}'인 학생을 찾을 수 없습니다.")

        removeStudent(student)
    }

    fun removeStudent(student: Student) = require(_students.remove(student)) {
        "'${student.name}' 학생을 찾을 수 없습니다."
    }

    fun rename(name: String) {
        require(name.isNotBlank()) {
            "이름을 공백으로 변경할 수 없습니다."
        }
        this.name = name
    }
}