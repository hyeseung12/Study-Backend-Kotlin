package kr.hs.study.studybackendkotlin.service.user

import kr.hs.study.studybackendkotlin.annotation.TransactionalService
import kr.hs.study.studybackendkotlin.dto.user.LoginUserRequest
import kr.hs.study.studybackendkotlin.dto.user.UserResponse
import kr.hs.study.studybackendkotlin.repository.user.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder

@TransactionalService
class LoginUserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun execute(request: LoginUserRequest): UserResponse {
        val user = userRepository.findByUserIdOrEmail(request.userId, request.password)

        if(!passwordEncoder.matches(request.password, user.password))
            throw RuntimeException("password is not equal")

        return UserResponse(user)
    }
}