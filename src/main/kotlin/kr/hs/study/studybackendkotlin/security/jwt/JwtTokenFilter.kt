package kr.hs.study.studybackendkotlin.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtTokenFilter (
    private val jwtTokenProvider: JwtTokenProvider
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token: String? = jwtTokenProvider.resolveToken(request) // 1. 토큰 디코딩
        token?.let {
            val authentication: Authentication = jwtTokenProvider.authorization(token)
            SecurityContextHolder.getContext().authentication = authentication // 2. 토큰 사용자 권한 줌
        }
        filterChain.doFilter(request, response)
    }
}