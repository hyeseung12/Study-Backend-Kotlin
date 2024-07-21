package kr.hs.study.studybackendkotlin.exception.error

import org.springframework.http.HttpStatus

class ErrorResponse(
    errorCode: ErrorCode
) {
    val status: HttpStatus = errorCode.status
    val message: String = errorCode.message
}