package kr.hs.study.studybackendkotlin.repository.user

import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import kr.hs.study.studybackendkotlin.entity.QUser.user
import kr.hs.study.studybackendkotlin.entity.User

class UserRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : UserRepositoryCustom {
    override fun findByUserId(userId: String): User {
        return jpaQueryFactory
            .selectFrom(user)
            .where(
                userIdEq(userId)
            )
            .fetchFirst()
    }

    override fun findByUserIdOrEmail(userId: String, email: String): User {
        return jpaQueryFactory
            .selectFrom(user)
            .where(
                userIdEq(userId),
                emailEq(email)
            )
            .fetchFirst()
    }

    private fun userIdEq(userId: String): BooleanExpression? =
        if (userId.isBlank()) user.userId.eq(userId) else null

    private fun emailEq(email: String): BooleanExpression? =
        if (email.isBlank()) user.email.eq(email) else null
}