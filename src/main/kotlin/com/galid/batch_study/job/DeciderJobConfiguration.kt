//package com.galid.batch_study.job
//
//import org.springframework.batch.core.Job
//import org.springframework.batch.core.JobExecution
//import org.springframework.batch.core.Step
//import org.springframework.batch.core.StepExecution
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
//import org.springframework.batch.core.job.flow.FlowExecutionStatus
//import org.springframework.batch.core.job.flow.JobExecutionDecider
//import org.springframework.batch.repeat.RepeatStatus
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import java.util.*
//import kotlin.random.Random as Random1
//
//
//@Configuration
//class DeciderJobConfiguration (
//    private val jobBuilderFactory: JobBuilderFactory,
//    private val stepBuilderFactory: StepBuilderFactory
//){
//    @Bean
//    fun deciderJob(): Job {
//        return jobBuilderFactory["deciderJob"]
//            .start(startStep())
//            .next(decider())
//            .from(decider())
//                .on("ODD")
//                .to(oddStep())
//            .from(decider())
//                .on("EVEN")
//                .to(evenStep())
//            .end()
//            .build()
//    }
//
//    @Bean
//    fun decider(): JobExecutionDecider {
//        return OddDecider()
//    }
//
//    @Bean
//    fun startStep(): Step {
//        return stepBuilderFactory["step1"]
//            .tasklet { contribution, chunkContext ->
//                println("step111111111111")
//                RepeatStatus.FINISHED
//            }
//            .build()
//    }
//
//    @Bean
//    fun oddStep(): Step {
//        return stepBuilderFactory["oddStep"]
//            .tasklet { contribution, chunkContext ->
//                println("odd Step")
//                RepeatStatus.FINISHED
//            }
//            .build()
//    }
//
//    @Bean
//    fun evenStep(): Step {
//        return stepBuilderFactory["evenStep"]
//            .tasklet { contribution, chunkContext ->
//                println("event step ")
//                RepeatStatus.FINISHED
//            }
//            .build()
//    }
//
//
//    class OddDecider : JobExecutionDecider {
//        override fun decide(
//            jobExecution: JobExecution,
//            stepExecution: StepExecution?
//        ): FlowExecutionStatus {
//            val rand = Random()
//            val randNum = rand.nextInt(50) + 1
//            println("random : ${randNum}")
//
//            if (randNum % 2 == 0)
//                return FlowExecutionStatus("EVEN")
//            else
//                return FlowExecutionStatus("ODD")
//        }
//    }
//}