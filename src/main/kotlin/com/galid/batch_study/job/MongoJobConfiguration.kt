package com.galid.batch_study.job

import com.galid.batch_study.model.Board
import com.galid.batch_study.processor.MongoItemProcessor
import com.mongodb.MongoSocketException
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.data.MongoItemReader
import org.springframework.batch.item.data.MongoItemWriter
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.dao.DeadlockLoserDataAccessException
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.retry.backoff.SleepingBackOffPolicy


@Configuration
class MongoJobConfiguration (
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val mongoTemplate: MongoTemplate,
    private val itemProcessor: ItemProcessor<Board, Board>
){
    @Bean
    fun mongoJob(): Job {
        return jobBuilderFactory["mongoJob"]
            .start(mongoChunkStep())
            .build()
    }

    @Bean
    fun mongoChunkStep(): Step {
        return stepBuilderFactory["mongoChunkStep"]
            .chunk<Board, Board>(10)
            .reader(mongoItemReader())
            .processor(itemProcessor)
            .writer(mongoItemWriter())
            .faultTolerant()
                .retryLimit(3)
                .retry(MongoSocketException::class.java)
                .retry(DeadlockLoserDataAccessException::class.java)
            .build();
    }

    private fun mongoItemReader(): MongoItemReader<out Board> {
        return MongoItemReaderBuilder<Board>()
            .pageSize(10)
            .sorts(mutableMapOf("_id" to Sort.DEFAULT_DIRECTION))
            .template(mongoTemplate)
            .targetType(Board::class.java)
            .jsonQuery("{}")
            .name("mongoBatchReader")
            .build()
    }

    private fun mongoItemWriter(): MongoItemWriter<in Board> {
        return MongoItemWriterBuilder<Board>()
            .collection("board")
            .template(mongoTemplate)
            .build()
    }

}