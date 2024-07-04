package kr.hs.study.studybackendkotlin.service.point

import kr.hs.study.studybackendkotlin.annotation.TransactionalService
import kr.hs.study.studybackendkotlin.dto.point.AddPointRequest
import kr.hs.study.studybackendkotlin.repository.point.PointRepository
import kr.hs.study.studybackendkotlin.repository.user.UserRepository
import org.springframework.data.repository.findByIdOrNull

@TransactionalService
class PostPointService(
    private val pointRepository: PointRepository,
    private val userRepository: UserRepository
) {
    fun execute(request: AddPointRequest) {
        val user = userRepository.findByIdOrNull(request.userId)
            ?: throw RuntimeException("user not found")

        pointRepository.save(request.toEntity(user))
    }
}