package kr.hs.study.studybackendkotlin.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
    var name: String,

    @Column(unique = true)
    val userId: String,

    @Column(unique = true)
    val email: String,

    var password: String,

) : BaseEntity()