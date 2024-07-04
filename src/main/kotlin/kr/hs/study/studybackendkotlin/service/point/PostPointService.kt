package kr.hs.study.studybackendkotlin.service.point

import kr.hs.study.studybackendkotlin.annotation.TransactionalService
import kr.hs.study.studybackendkotlin.dto.point.AddPointRequest
import kr.hs.study.studybackendkotlin.repository.point.PointRepository
import kr.hs.study.studybackendkotlin.repository.user.UserRepository

@TransactionalService
class PostPointService(
    private val pointRepository: PointRepository,
    private val userRepository: UserRepository
) {
    fun execute(request: AddPointRequest) {
        if(!userRepository.existsById(request.user.id))
            throw RuntimeException("user not found")

        pointRepository.save(request.toEntity())
    }
}