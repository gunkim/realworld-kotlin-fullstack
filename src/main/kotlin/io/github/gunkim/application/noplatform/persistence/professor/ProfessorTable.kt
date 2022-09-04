package io.github.gunkim.application.noplatform.persistence.professor

import org.jetbrains.exposed.dao.id.LongIdTable

object ProfessorTable : LongIdTable() {
    val name = varchar("name", 10)
}