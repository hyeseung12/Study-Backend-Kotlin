package kr.hs.study.studybackendkotlin.dto.user

import jakarta.validation.constraints.NotBlank

class UpdateUserRequest(
    @field:NotBlank
    val password: String
)