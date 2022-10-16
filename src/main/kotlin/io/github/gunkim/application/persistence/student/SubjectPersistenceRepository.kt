package io.github.gunkim.application.persistence.student

import io.github.gunkim.domain.student.Subject
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.transactions.transaction

class SubjectPersistenceRepository {
    fun saveAll(studentEntity: StudentEntity, subjects: List<Subject>): List<Subject> = transaction {
        subjects.map {
            insertOrUpdate(studentEntity, it)
        }.map(SubjectEntity::toDomain)
            .also {
                val ids = it.mapNotNull(Subject::id).map { EntityID(it, SubjectTable) }
                SubjectTable.deleteWhere { SubjectTable.student eq studentEntity.id and (SubjectTable.id notInList ids) }
            }
    }

    private fun insertOrUpdate(studentEntity: StudentEntity, subject: Subject): SubjectEntity {
        return if (subject.id != null) {
            SubjectEntity.findById(subject.id)
                ?.apply {
                    type = subject.type
                    score = subject.score
                }
                ?: throw IllegalArgumentException("디비에 없당께롱")
        } else {
            SubjectEntity.new {
                type = subject.type
                score = subject.score
                this.student = studentEntity
            }
        }
    }
}