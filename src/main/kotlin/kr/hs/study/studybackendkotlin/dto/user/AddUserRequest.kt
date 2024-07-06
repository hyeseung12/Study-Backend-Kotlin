package kr.hs.study.studybackendkotlin.dto.user

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import kr.hs.study.studybackendkotlin.entity.User

data class AddUserRequest(
    // field: 를 사용한 이유 : https://devlog-wjdrbs96.tistory.com/407
    @field:NotNull
    val name: String,

    @field:NotBlank
    val userId: String,

    @field:NotBlank
    val email: String,

    @field:NotBlank
    var password: String
) {

    fun toEntity() = User(
        name = name,
        userId = userId,
        email = email,
        password = password
    )

}