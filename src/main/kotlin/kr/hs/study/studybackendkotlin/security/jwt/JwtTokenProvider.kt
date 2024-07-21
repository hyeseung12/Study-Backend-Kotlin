package kr.hs.study.studybackendkotlin.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import kr.hs.study.studybackendkotlin.config.properties.JwtProperties
import kr.hs.study.studybackendkotlin.entity.RefreshToken
import kr.hs.study.studybackendkotlin.exception.ExpiredJwtException
import kr.hs.study.studybackendkotlin.repository.auth.RefreshTokenRepository
import kr.hs.study.studybackendkotlin.service.auth.UserDetailsService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: UserDetailsService,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    private val ACCESS_KEY: String = "access_token"
    private val REFRESH_KEY: String = "refresh_token"

    // 토큰 추가
    fun createToken(userId: String, type: String, time: Long): String {
        val now = Date()

        return Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(userId)
            .setHeaderParam("type", type)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + time))
            .compact()
    }

    // access 토큰 추가
    fun createAccessToken(userId: String): String
        = createToken(userId, ACCESS_KEY, jwtProperties.accessTime)

    // refresh 토큰 추가
    fun createRefreshToken(userId: String): String {
        val token: String = createToken(userId, REFRESH_KEY, jwtProperties.refreshTime)
        refreshTokenRepository.save(RefreshToken(token, userId))
        return token
    }

    // 토큰 인코딩
    fun parseToken(bearerToken: String?): String? {
        val prefix = jwtProperties.prefix + " "
        if (bearerToken != null && bearerToken.startsWith(prefix)) {
            return bearerToken.replace(prefix, "")
        }
        return null
    }

    // 토큰 디코딩
    fun resolveToken(request: HttpServletRequest): String? {
        val bearer: String? = request.getHeader(jwtProperties.header)
        return parseToken(bearer)
    }

    // 사용자 권한 (인가)
    fun authorization(token: String): UsernamePasswordAuthenticationToken {
        val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    // 1. userId을 받기 위해 parser
    fun getTokenBody(token: String): Claims {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.secretKey)
                .parseClaimsJwt(token).body
        } catch (e: Exception) {
            throw ExpiredJwtException()
        }
    }

    // 2. userId 받기
    fun getTokenSubject(subject: String): String
        = getTokenBody(subject).subject
}