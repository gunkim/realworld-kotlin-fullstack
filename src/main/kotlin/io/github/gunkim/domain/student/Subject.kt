package io.github.gunkim.domain.student

class Subject(
    val id: Long? = null,
    val type: SubjectType,
    score: Int = 0,
) {
    init {
        require(score >= 0) {
            "점수는 음수가 될 수 없습니다. (score: ${score})"
        }
    }
    private var _score = score
    val score
        get() = _score

    fun changeScore(score: Int) {
        require(score >= 0) {
            throw IllegalArgumentException("점수는 음수가 될 수 없습니다. (score : ${score})")
        }
        _score = score
    }
}