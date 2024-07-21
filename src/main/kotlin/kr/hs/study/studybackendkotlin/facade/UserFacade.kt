package kr.hs.study.studybackendkotlin.facade

import kr.hs.study.studybackendkotlin.entity.User
import kr.hs.study.studybackendkotlin.repository.user.UserRepository
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder

@Configuration
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getCurrentUser(): User {
        val userId: String = SecurityContextHolder.getContext().authentication.name
        return getUserByUserId(userId)
    }

    fun getUserByUserId(userId: String)
            = userRepository.findByUserId(userId)

    fun isLogin(): Boolean {
        val authentication = SecurityContextHolder.getContext().authentication
        if (authentication == null || authentication is AnonymousAuthenticationToken) return false
        return authentication.isAuthenticated
    }
}