package com.galid.batch_study.job

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StepNextConditionalJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {
    @Bean
    fun conditionJob(): Job {
        return jobBuilderFactory["conditionJob"]
            .start(conditionalStep1())
                .on(ExitStatus.FAILED.exitCode)
                .to(conditionalStep3())
                .on("*")
                .end()
            .from(conditionalStep1())
                .on("*")
                .to(conditionalStep2())
                .next(conditionalStep3())
                .on("*")
                .end()
            .end()
            .build()
    }

    @Bean
    fun conditionalStep1(): Step {
        return stepBuilderFactory["conditionalStep1"]
            .tasklet { contribution: StepContribution, chunkContext: ChunkContext ->
                println("conditional 1111111")
                contribution.exitStatus = ExitStatus.FAILED
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun conditionalStep2(): Step {
        return stepBuilderFactory["conditionalStep2"]
            .tasklet { contribution, chunkContext ->
                println("conditional Step22222222")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun conditionalStep3(): Step {
        return stepBuilderFactory["conditionalStep3"]
            .tasklet { contribution, chunkContext ->
                println("conditional Step 333333333")
                RepeatStatus.FINISHED
            }
            .build()
    }

}