package kr.hs.study.studybackendkotlin.repository.auth

import kr.hs.study.studybackendkotlin.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
}