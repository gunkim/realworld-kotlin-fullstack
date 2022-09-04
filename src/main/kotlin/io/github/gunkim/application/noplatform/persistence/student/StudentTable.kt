package io.github.gunkim.application.noplatform.persistence.student

import io.github.gunkim.application.noplatform.persistence.professor.ProfessorTable
import org.jetbrains.exposed.dao.id.LongIdTable

object StudentTable : LongIdTable() {
    val name = varchar("name", 10)
    val professor = reference("professor", ProfessorTable)
}