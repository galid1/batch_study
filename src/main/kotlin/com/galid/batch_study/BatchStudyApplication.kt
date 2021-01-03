package com.galid.batch_study

import com.galid.batch_study.repository.BoardRepository
import com.galid.batch_study.service.DummyCreator
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class BatchStudyApplication(
    val dummyCreator: DummyCreator,
    val boardRepository: BoardRepository
)
//): CommandLineRunner {
//
//    override fun run(vararg args: String?) {
//        val findAll = boardRepository.findAll()
//        println(findAll.size)
//    }
//}



fun main(args: Array<String>) {
    runApplication<BatchStudyApplication>(*args)
}
