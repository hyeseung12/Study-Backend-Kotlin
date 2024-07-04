package kr.hs.study.studybackendkotlin.dto.point

import kr.hs.study.studybackendkotlin.entity.Point
import kr.hs.study.studybackendkotlin.entity.User

data class PointResponse(
    val id: Long,
    val variation: Long,
    val balance: Long,
    val user: User
) {

    constructor(point: Point): this(
        point.id,
        point.variation,
        point.balance,
        point.user
    )

}