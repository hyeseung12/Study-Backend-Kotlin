package kr.hs.study.studybackendkotlin.dto.user

import jakarta.validation.constraints.NotBlank

data class LoginUserRequest(
    @field:NotBlank
    val userId: String,

    @field:NotBlank
    val password: String
)