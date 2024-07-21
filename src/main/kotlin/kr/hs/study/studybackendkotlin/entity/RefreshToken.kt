package kr.hs.study.studybackendkotlin.entity

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "refreshToken", timeToLive = 2592000L)
class RefreshToken(
    @Id
    val token: String,
    val userId: Long
)