package kr.hs.study.studybackendkotlin.exception

import kr.hs.study.studybackendkotlin.exception.error.BusinessException
import kr.hs.study.studybackendkotlin.exception.error.ErrorCode

class ExpiredJwtException: BusinessException(
    ErrorCode.EXPIRED_JWT
)