package kr.hs.study.studybackendkotlin.controller

import jakarta.validation.Valid
import kr.hs.study.studybackendkotlin.dto.user.AddUserRequest
import kr.hs.study.studybackendkotlin.service.user.PostUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val postUserService: PostUserService
) {
    @PostMapping
    fun addUser(@Valid @RequestBody request: AddUserRequest) : ResponseEntity<Void> {
        postUserService.execute(request)
        return ResponseEntity.ok().build()
    }
}