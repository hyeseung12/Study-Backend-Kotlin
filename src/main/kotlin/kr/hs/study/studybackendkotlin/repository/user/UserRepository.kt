package kr.hs.study.studybackendkotlin.repository.user

import kr.hs.study.studybackendkotlin.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>, UserRepositoryCustom {
    fun existsByUserId(userId: String) : Boolean
    fun existsByEmail(email: String): Boolean
}