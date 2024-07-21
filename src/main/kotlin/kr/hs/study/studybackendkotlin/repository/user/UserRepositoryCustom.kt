package kr.hs.study.studybackendkotlin.repository.user

import kr.hs.study.studybackendkotlin.entity.User

interface UserRepositoryCustom {
    fun findByUserId(userId: String): User
    fun findByUserIdOrEmail(userId: String, email:String): User
}