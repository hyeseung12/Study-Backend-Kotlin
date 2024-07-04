package kr.hs.study.studybackendkotlin.dto.point

import kr.hs.study.studybackendkotlin.entity.Point
import kr.hs.study.studybackendkotlin.entity.User
import org.jetbrains.annotations.NotNull

class AddPointRequest(
    @field:NotNull
    val variation: Long,

    @field:NotNull
    val balance: Long,

    @field:NotNull
    val user: User
) {

    fun toEntity() = Point(
        variation = variation,
        balance = balance,
        user = user
    )

}