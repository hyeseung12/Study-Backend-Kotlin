package kr.hs.study.studybackendkotlin.repository.point

import kr.hs.study.studybackendkotlin.entity.Point
import org.springframework.data.jpa.repository.JpaRepository

interface PointRepository : JpaRepository<Point, Long> {
}