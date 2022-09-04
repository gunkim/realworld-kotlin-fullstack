package io.github.gunkim.application.noplatform.persistence.student

import io.github.gunkim.application.noplatform.persistence.professor.ProfessorEntity
import io.github.gunkim.domain.student.Student
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.transactions.transaction

class StudentPersistenceRepository {
    private val subjectRepository = SubjectPersistenceRepository()

    fun saveAll(professorEntity: ProfessorEntity, students: List<Student>): List<Student> = transaction {
        students.map { student ->
            insertOrUpdate(professorEntity, student).let {
                it.toDomain(subjectRepository.saveAll(it, student.subjects))
            }
        }.also {
            val ids = it.mapNotNull(Student::id).map { EntityID(it, StudentTable) }
            StudentTable.deleteWhere { StudentTable.professor eq professorEntity.id and (StudentTable.id notInList ids) }
        }
    }

    private fun insertOrUpdate(professorEntity: ProfessorEntity, student: Student): StudentEntity {
        return if (student.id != null) {
            StudentEntity.findById(student.id)
                ?.also { it.name = student.name }
                ?: throw IllegalArgumentException("디비에 없당께롱")
        } else {
            StudentEntity.new {
                name = student.name
                this.professor = professorEntity
            }
        }
    }
}
