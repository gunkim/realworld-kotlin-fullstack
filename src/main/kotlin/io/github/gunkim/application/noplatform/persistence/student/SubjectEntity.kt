package io.github.gunkim.application.noplatform.persistence.student

import io.github.gunkim.domain.student.Subject
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class SubjectEntity(id: EntityID<Long>) : LongEntity(id) {
    var type by SubjectTable.type
    var score by SubjectTable.score
    var student by StudentEntity referencedOn SubjectTable.student

    fun toDomain(): Subject {
        return Subject(
            id = this.id.value,
            type = this.type,
            score = this.score
        )
    }

    companion object : LongEntityClass<SubjectEntity>(SubjectTable)
}