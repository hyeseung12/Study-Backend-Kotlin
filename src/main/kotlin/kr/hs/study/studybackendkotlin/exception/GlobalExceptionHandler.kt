package kr.hs.study.studybackendkotlin.exception

import kr.hs.study.studybackendkotlin.exception.error.BusinessException
import kr.hs.study.studybackendkotlin.exception.error.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    protected fun handleBusinessException(e: BusinessException): ResponseEntity<ErrorResponse> {
        val errorCode = e.errorCode
        val response = ErrorResponse(errorCode)

        return ResponseEntity<ErrorResponse>(response, errorCode.status)
    }

}