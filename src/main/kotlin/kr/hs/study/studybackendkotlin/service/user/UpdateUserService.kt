package kr.hs.study.studybackendkotlin.service.user

import kr.hs.study.studybackendkotlin.annotation.TransactionalService
import kr.hs.study.studybackendkotlin.dto.user.UpdateUserRequest
import kr.hs.study.studybackendkotlin.dto.user.UserResponse
import kr.hs.study.studybackendkotlin.exception.UserNotFoundException
import kr.hs.study.studybackendkotlin.repository.user.UserRepository
import org.springframework.data.repository.findByIdOrNull

@TransactionalService
class UpdateUserService(
    private val userRepository: UserRepository
) {
    fun execute(id: Long, request: UpdateUserRequest): UserResponse {
        val user = userRepository.findByIdOrNull(id)
            ?: throw UserNotFoundException()

        user.password = request.password
        return UserResponse(user)
    }
}