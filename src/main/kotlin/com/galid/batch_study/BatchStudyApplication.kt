package com.galid.batch_study

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class BatchStudyApplication

fun main(args: Array<String>) {
    runApplication<BatchStudyApplication>(*args)
}
