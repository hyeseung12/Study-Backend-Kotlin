package kr.hs.study.studybackendkotlin.exception.error

open class BusinessException(
    val errorCode: ErrorCode
): RuntimeException(errorCode.message) {
    @Synchronized
    override fun fillInStackTrace(): Throwable {
        return this
    }
}