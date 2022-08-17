package io.github.gunkim.domain

class Subject(
    val id: Long? = null,
    val type: SubjectType,
    var score: Int,
) {
    fun changeScore(score: Int) {
        require(score >= 0) {
            throw IllegalArgumentException("점수는 음수가 될 수 없습니다. (score : ${score})")
        }
        this.score = score
    }
}