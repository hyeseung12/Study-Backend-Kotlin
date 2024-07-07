package kr.hs.study.studybackendkotlin.service.user

import kr.hs.study.studybackendkotlin.annotation.TransactionalService
import kr.hs.study.studybackendkotlin.dto.user.AddUserRequest
import kr.hs.study.studybackendkotlin.repository.user.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder

@TransactionalService
class PostUserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun execute(request: AddUserRequest) {
        duplicateUserId(request.userId)
        duplicateEmail(request.email)

        request.password = passwordEncoder.encode(request.password)

        userRepository.save(request.toEntity())
    }

    fun duplicateEmail(email: String) : Boolean = if(userRepository.existsByEmail(email)) throw RuntimeException("이메일 에러") else true
    fun duplicateUserId(userId: String) : Boolean = if(userRepository.existsByUserId(userId)) throw RuntimeException("유저 아이디 에러") else true
}