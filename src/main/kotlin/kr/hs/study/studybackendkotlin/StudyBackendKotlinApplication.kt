package kr.hs.study.studybackendkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class StudyBackendKotlinApplication

fun main(args: Array<String>) {
    runApplication<StudyBackendKotlinApplication>(*args)
}
