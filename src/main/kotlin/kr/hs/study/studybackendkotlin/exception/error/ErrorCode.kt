package kr.hs.study.studybackendkotlin.exception.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: HttpStatus,
    val message: String
) {
    USER_INCORRECT(HttpStatus.BAD_REQUEST, "Check your email/id or password"),

    USER_DUPLICATE(HttpStatus.CONFLICT, "아이디 또는 이메일이 중복되었습니다."),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),

    EXPIRED_JWT(HttpStatus.UNAUTHORIZED, "Expired Jwt"),
}