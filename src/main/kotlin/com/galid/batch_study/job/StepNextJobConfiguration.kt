//package com.galid.batch_study.job
//
//import org.springframework.batch.core.Job
//import org.springframework.batch.core.Step
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
//import org.springframework.batch.repeat.RepeatStatus
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//class StepNextJobConfiguration (
//    private val jobBuilderFactory: JobBuilderFactory,
//    private val stepBuilderFactory: StepBuilderFactory
//){
//    @Bean
//    fun stepNextJob(): Job {
//        return jobBuilderFactory["stepNextJob"]
//            .start(step1())
//            .next(step2())
//            .build();
//    }
//
//    @Bean
//    fun step1(): Step {
//        return stepBuilderFactory["step1"]
//            .tasklet { contribution, chunkContext ->
//                println("step 11111111")
//                RepeatStatus.FINISHED
//            }
//            .build()
//    }
//
//    @Bean
//    fun step2(): Step {
//        return stepBuilderFactory["step2"]
//            .tasklet { contribution, chunkContext ->
//                println("step 22222222222222")
//                RepeatStatus.FINISHED
//            }
//            .build()
//    }
//}