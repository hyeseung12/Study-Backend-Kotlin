package kr.hs.study.studybackendkotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {
    @GetMapping
    fun health() : Boolean {
        return true
    }
}