package io.github.gunkim.application.persistence

import io.github.gunkim.domain.student.Student
import io.github.gunkim.domain.student.StudentRepository

class FakeStudentRepository : StudentRepository {
    private val map: MutableMap<Long, Student> = hashMapOf()

    override fun findById(id: Long): Student = map[id] ?: throw NoSuchElementException("'${id}' 아이디를 가진 학생을 찾을 수 없습니다.")

    override fun save(student: Student): Student {
        val studentId = student.id
            ?.also { map.remove(it) }
            ?: generateId()

        return map.set(studentId, student).let { student }
    }

    private fun generateId(): Long = map.size.toLong() + 1
}