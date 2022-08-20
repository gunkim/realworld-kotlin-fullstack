package io.github.gunkim.application.noplatform.persistence

import io.github.gunkim.domain.professor.Professor
import io.github.gunkim.domain.professor.ProfessorRepository

class FakeProfessorRepository : ProfessorRepository {
    private val map: MutableMap<Long, Professor> = hashMapOf()

    override fun findById(id: Long): Professor = map[id] ?: throw NoSuchElementException("'${id}' 아이디를 가진 교수를 찾을 수 없습니다.")

    override fun save(professor: Professor): Professor = map.set(generateId(), professor).let { professor }

    private fun generateId(): Long = map.size.toLong() + 1
}