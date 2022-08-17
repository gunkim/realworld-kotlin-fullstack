package io.github.gunkim.domain

class Professor(
    val id: Long? = null,
    var name: String,
    val students: MutableList<Student> = mutableListOf(),
) {
    fun removeStudent(student: Student) {
        if (students.contains(student)) {
            students.remove(student)
        } else throw IllegalArgumentException("'${student.name}' 학생을 찾을 수 없습니다.")
    }
}