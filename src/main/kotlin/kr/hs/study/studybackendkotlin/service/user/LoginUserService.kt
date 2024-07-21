package kr.hs.study.studybackendkotlin.service.user

import kr.hs.study.studybackendkotlin.annotation.TransactionalService
import kr.hs.study.studybackendkotlin.dto.auth.TokenResponse
import kr.hs.study.studybackendkotlin.dto.user.LoginUserRequest
import kr.hs.study.studybackendkotlin.repository.user.UserRepository
import kr.hs.study.studybackendkotlin.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder

@TransactionalService
class LoginUserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun execute(request: LoginUserRequest): TokenResponse {
        val userId = request.userId
        val password = request.password

        val user = userRepository.findByUserIdOrEmail(userId, password)

        if(!passwordEncoder.matches(password, user.password))
            throw RuntimeException("password is not equal")

        return TokenResponse(
            jwtTokenProvider.createAccessToken(userId),
            jwtTokenProvider.createRefreshToken(userId)
        )
    }
}