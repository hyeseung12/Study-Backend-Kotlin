package kr.hs.study.studybackendkotlin.service.user

import kr.hs.study.studybackendkotlin.annotation.ReadOnlyService
import kr.hs.study.studybackendkotlin.dto.user.UserResponse
import kr.hs.study.studybackendkotlin.repository.user.UserRepository
import org.springframework.data.repository.findByIdOrNull

@ReadOnlyService
class GetUserService(
    private val userRepository: UserRepository
) {
    fun execute(id: Long): UserResponse {
        val user = userRepository.findByIdOrNull(id)
            ?: throw RuntimeException("user not found")

        return UserResponse(user)
    }
}