package io.github.gunkim.application.persistence.professor

import io.github.gunkim.application.persistence.student.*
import io.github.gunkim.domain.professor.Professor
import io.github.gunkim.domain.professor.ProfessorRepository
import org.jetbrains.exposed.sql.SizedIterable
import org.jetbrains.exposed.sql.transactions.transaction

class ProfessorPersistenceRepository : ProfessorRepository {
    private val studentRepository = StudentPersistenceRepository()

    override fun findById(id: Long): Professor = transaction {
        val professor = ProfessorEntity.findById(id) ?: throw IllegalArgumentException("없엄")
        val students: SizedIterable<StudentEntity> = StudentEntity.find { StudentTable.professor eq professor.id }
        val subjects: SizedIterable<SubjectEntity> = SubjectEntity.find { SubjectTable.student inList students.map { it.id } }

        professor.toDomain(students.map { student ->
            student.toDomain(subjects.run {
                filter { it.student == student }
                    .map(SubjectEntity::toDomain)
                    .toMutableList()
            })
        })
    }

    override fun save(professor: Professor): Professor = transaction {
        ProfessorEntity.insertOrUpdate(professor)
            .let { it.toDomain(studentRepository.saveAll(it, professor.students)) }
    }
}