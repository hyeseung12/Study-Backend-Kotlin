package kr.hs.study.studybackendkotlin.service.auth

import kr.hs.study.studybackendkotlin.annotation.ReadOnlyService
import kr.hs.study.studybackendkotlin.dto.auth.AccessTokenResponse
import kr.hs.study.studybackendkotlin.entity.RefreshToken
import kr.hs.study.studybackendkotlin.exception.ExpiredJwtException
import kr.hs.study.studybackendkotlin.repository.auth.RefreshTokenRepository
import kr.hs.study.studybackendkotlin.security.jwt.JwtTokenProvider
import org.springframework.data.repository.findByIdOrNull

@ReadOnlyService
class GetAccessTokenService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun execute(token: String): AccessTokenResponse {
        val refreshToken: RefreshToken = getRefreshToken(token)
        return AccessTokenResponse(
            jwtTokenProvider.createAccessToken(refreshToken.userId)
        )
    }

    fun getRefreshToken(token: String) = refreshTokenRepository.findByIdOrNull(token)
        ?: throw ExpiredJwtException()
}