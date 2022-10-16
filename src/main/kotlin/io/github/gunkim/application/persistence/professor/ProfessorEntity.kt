package io.github.gunkim.application.persistence.professor

import io.github.gunkim.domain.professor.Professor
import io.github.gunkim.domain.student.Student
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ProfessorEntity(id: EntityID<Long>) : LongEntity(id) {
    var name by ProfessorTable.name

    fun toDomain(subjects: List<Student>): Professor {
        return Professor(
            id = this.id.value,
            name = this.name,
            students = subjects
        )
    }

    companion object : LongEntityClass<ProfessorEntity>(ProfessorTable) {
        fun insertOrUpdate(professor: Professor): ProfessorEntity {
            return if (professor.id != null) {
                findById(professor.id)
                    ?.also { it.name = professor.name }
                    ?: throw IllegalArgumentException("디비에 없당께롱")
            } else {
                new { name = professor.name }
            }
        }
    }
}