package kr.hs.study.studybackendkotlin.dto.auth

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)