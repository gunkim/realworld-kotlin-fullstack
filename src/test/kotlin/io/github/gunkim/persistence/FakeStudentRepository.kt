package io.github.gunkim.persistence

import io.github.gunkim.domain.Student
import io.github.gunkim.domain.StudentRepository

class FakeStudentRepository : StudentRepository {
    private val map: MutableMap<Long, Student> = hashMapOf()

    override fun findById(id: Long): Student = map[id] ?: throw NoSuchElementException("'${id}' 아이디를 가진 학생을 찾을 수 없습니다.")

    override fun save(student: Student): Student = map.set(generateId(), student).let { student }

    private fun generateId(): Long = map.size.toLong() + 1
}