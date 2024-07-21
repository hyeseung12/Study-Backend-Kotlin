package kr.hs.study.studybackendkotlin.service.auth

import kr.hs.study.studybackendkotlin.entity.AuthDetails
import kr.hs.study.studybackendkotlin.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService (
    private val userFacade: UserFacade
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails
        = AuthDetails(userFacade.getUserByUserId(username))
}