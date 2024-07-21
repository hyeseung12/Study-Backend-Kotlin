package kr.hs.study.studybackendkotlin.service.user

import kr.hs.study.studybackendkotlin.annotation.ReadOnlyService
import kr.hs.study.studybackendkotlin.dto.user.UserResponse
import kr.hs.study.studybackendkotlin.exception.UserNotFoundException
import kr.hs.study.studybackendkotlin.repository.user.UserRepository
import org.springframework.data.repository.findByIdOrNull

@ReadOnlyService
class GetUserService(
    private val userRepository: UserRepository
) {
    fun execute(id: Long): UserResponse {
        /*
            - java 스타일
            userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION)
        */
        val user = userRepository.findByIdOrNull(id)
            ?: throw UserNotFoundException()

        return UserResponse(user)
    }
}