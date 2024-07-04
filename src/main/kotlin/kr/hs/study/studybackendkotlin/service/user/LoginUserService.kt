package kr.hs.study.studybackendkotlin.service.user

import kr.hs.study.studybackendkotlin.annotation.TransactionalService
import kr.hs.study.studybackendkotlin.dto.user.LoginUserRequest
import kr.hs.study.studybackendkotlin.dto.user.UserResponse
import kr.hs.study.studybackendkotlin.repository.user.UserRepository

@TransactionalService
class LoginUserService(
    private val userRepository: UserRepository
) {
    fun execute(request: LoginUserRequest): UserResponse {
        val user = userRepository.findByUserIdOrEmail(request.userId, request.password)
        return UserResponse(user)
    }
}