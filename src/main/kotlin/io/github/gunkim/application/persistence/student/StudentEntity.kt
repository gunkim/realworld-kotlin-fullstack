package io.github.gunkim.application.persistence.student

import io.github.gunkim.application.persistence.professor.ProfessorEntity
import io.github.gunkim.domain.student.Student
import io.github.gunkim.domain.student.Subject
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class StudentEntity(id: EntityID<Long>) : LongEntity(id) {

    var name by StudentTable.name
    var professor by ProfessorEntity referencedOn StudentTable.professor

    fun toDomain(subjects: List<Subject>): Student {
        return Student(
            id = this.id.value,
            name = this.name,
            subjects = subjects
        )
    }

    companion object : LongEntityClass<StudentEntity>(StudentTable)
}