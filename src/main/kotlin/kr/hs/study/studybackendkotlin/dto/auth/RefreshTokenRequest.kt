package kr.hs.study.studybackendkotlin.dto.auth

import org.jetbrains.annotations.NotNull

data class RefreshTokenRequest(
    @field:NotNull
    val refreshToken: String
)