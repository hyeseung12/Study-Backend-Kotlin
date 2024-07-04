package kr.hs.study.studybackendkotlin.controller

import jakarta.validation.Valid
import kr.hs.study.studybackendkotlin.dto.user.AddUserRequest
import kr.hs.study.studybackendkotlin.dto.user.LoginUserRequest
import kr.hs.study.studybackendkotlin.dto.user.UpdateUserRequest
import kr.hs.study.studybackendkotlin.dto.user.UserResponse
import kr.hs.study.studybackendkotlin.service.user.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val postUserService: PostUserService,
    private val loginUserService: LoginUserService,
    private val getUserService: GetUserService,
    private val updateUserService: UpdateUserService,
    private val deleteUserService: DeleteUserService,
) {
    @PostMapping
    fun addUser(@Valid @RequestBody request: AddUserRequest): ResponseEntity<Void> {
        postUserService.execute(request)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/login")
    fun loginUser(@Valid @RequestBody request: LoginUserRequest): ResponseEntity<UserResponse> {
        val user = loginUserService.execute(request)
        return ResponseEntity.ok(user)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<UserResponse> {
        val user = getUserService.execute(id)
        return ResponseEntity.ok(user)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id:Long, @Valid @RequestBody request: UpdateUserRequest): ResponseEntity<UserResponse> {
        val user = updateUserService.execute(id, request)
        return ResponseEntity.ok(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id:Long): ResponseEntity<UserResponse> {
        val user = deleteUserService.execute(id)
        return ResponseEntity.ok().build()
    }
}