package io.github.gunkim.application.persistence.student

import io.github.gunkim.domain.student.SubjectType
import org.jetbrains.exposed.dao.id.LongIdTable

object SubjectTable : LongIdTable() {
    val type = enumeration<SubjectType>("type")
    val score = integer("score")
    val student = reference("student", StudentTable)
}