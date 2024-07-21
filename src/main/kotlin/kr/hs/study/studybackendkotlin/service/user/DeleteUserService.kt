package kr.hs.study.studybackendkotlin.service.user

import kr.hs.study.studybackendkotlin.annotation.TransactionalService
import kr.hs.study.studybackendkotlin.exception.UserNotFoundException
import kr.hs.study.studybackendkotlin.repository.user.UserRepository
import org.springframework.data.repository.findByIdOrNull

@TransactionalService
class DeleteUserService(
    private val userRepository: UserRepository
) {
    fun execute(id: Long) {
        val user = userRepository.findByIdOrNull(id)
            ?: throw UserNotFoundException()
        userRepository.delete(user)
    }
}