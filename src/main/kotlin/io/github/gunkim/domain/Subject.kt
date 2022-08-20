package io.github.gunkim.domain

class Subject(
    val id: Long? = null,
    val type: SubjectType,
    score: Int,
) {
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