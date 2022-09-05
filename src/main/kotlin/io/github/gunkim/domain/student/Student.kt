package io.github.gunkim.domain.student

class Student(
    val id: Long? = null,
    name: String,
    subjects: List<Subject> = listOf(),
) {
    var name: String = name
        private set

    private val _subjects: MutableList<Subject> = subjects.toMutableList()
    val subjects: List<Subject>
        get() = _subjects

    fun addSubject(subject: Subject) {
        _subjects.add(subject)
    }

    fun rename(name: String) {
        require(name.isNotBlank()) {
            "이름을 공백으로 변경할 수 없습니다."
        }
        this.name = name
    }

    fun changeSubjectScore(subjectId: Long, score: Int) {
        val subject = subjects.firstOrNull { it.id == subjectId }
            ?: throw IllegalArgumentException("해당 과목이 존재하지 않습니다.")

        subject.changeScore(score)
    }
}