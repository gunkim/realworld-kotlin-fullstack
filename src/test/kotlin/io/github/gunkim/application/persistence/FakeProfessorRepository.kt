package io.github.gunkim.application.persistence

import io.github.gunkim.domain.professor.Professor
import io.github.gunkim.domain.professor.ProfessorRepository

class FakeProfessorRepository : ProfessorRepository {
    private val map: MutableMap<Long, Professor> = hashMapOf()

    override fun findById(id: Long): Professor = map[id] ?: throw NoSuchElementException("'${id}' 아이디를 가진 교수를 찾을 수 없습니다.")

    override fun save(professor: Professor): Professor {
        val professorId = professor.id
            ?.also { map.remove(it) }
            ?: generateId()

        return map.set(professorId, professor).let { professor }
    }

    private fun generateId(): Long = map.size.toLong() + 1
}