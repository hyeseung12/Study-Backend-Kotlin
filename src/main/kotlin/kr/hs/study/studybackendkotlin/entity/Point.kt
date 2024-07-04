package kr.hs.study.studybackendkotlin.entity

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Point(
    var variation: Long,

    var balance: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User

) : BaseEntity()