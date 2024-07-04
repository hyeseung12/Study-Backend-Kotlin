package kr.hs.study.studybackendkotlin.controller

import jakarta.validation.Valid
import kr.hs.study.studybackendkotlin.dto.point.AddPointRequest
import kr.hs.study.studybackendkotlin.service.point.PostPointService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/point")
class PointController(
    private val postPointService: PostPointService
) {
    @PostMapping
    fun addPoint(@Valid @RequestBody request: AddPointRequest): ResponseEntity<Void> {
        postPointService.execute(request)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}