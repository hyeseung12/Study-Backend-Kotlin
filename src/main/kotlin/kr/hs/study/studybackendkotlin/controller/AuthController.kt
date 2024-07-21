package kr.hs.study.studybackendkotlin.controller

import jakarta.validation.Valid
import kr.hs.study.studybackendkotlin.dto.auth.RefreshTokenRequest
import kr.hs.study.studybackendkotlin.service.auth.GetAccessTokenService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val getAccessTokenService: GetAccessTokenService
) {
    @PostMapping
    fun createAccessToken(@RequestBody @Valid request: RefreshTokenRequest)
        = getAccessTokenService.execute(request.refreshToken)
}