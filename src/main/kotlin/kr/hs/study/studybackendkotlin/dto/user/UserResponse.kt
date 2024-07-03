package kr.hs.study.studybackendkotlin.dto.user

import kr.hs.study.studybackendkotlin.entity.User
import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val name: String,
    val userId: String,
    val email: String,
    val createdDate: LocalDateTime?
) {

    constructor(user: User): this(
        user.id,
        user.name,
        user.userId,
        user.email,
        user.createdDate
    )

}