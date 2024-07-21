package kr.hs.study.studybackendkotlin.exception

import kr.hs.study.studybackendkotlin.exception.error.BusinessException
import kr.hs.study.studybackendkotlin.exception.error.ErrorCode

class UserNotFoundException: BusinessException(
    ErrorCode.USER_NOT_FOUND
)