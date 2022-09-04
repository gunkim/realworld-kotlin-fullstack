package io.github.gunkim.application.noplatform.persistence.professor

import io.github.gunkim.application.noplatform.persistence.student.*
import io.github.gunkim.domain.professor.Professor
import io.github.gunkim.domain.professor.ProfessorRepository
import io.github.gunkim.domain.student.Student
import io.github.gunkim.domain.student.Subject
import io.github.gunkim.domain.student.SubjectType
import org.jetbrains.exposed.sql.SchemaUtils
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

fun main() {

    transaction {
        SchemaUtils.drop(ProfessorTable, StudentTable, SubjectTable)
        SchemaUtils.create(ProfessorTable, StudentTable, SubjectTable)
    }
    val repository = ProfessorPersistenceRepository()

    repository.save(
        Professor(
            name = "헬로우 거니",
            students = listOf(
                Student(
                    name = "김쿠릉",
                    subjects = listOf(
                        Subject(
                            type = SubjectType.English,
                            score = 98
                        ),
                        Subject(
                            type = SubjectType.Math,
                            score = 12
                        ),
                        Subject(
                            type = SubjectType.History,
                            score = 56
                        )
                    )
                ),
                Student(
                    name = "주니"
                )
            )
        )
    )
}