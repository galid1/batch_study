package com.galid.batch_study.processor

import com.galid.batch_study.model.Board
import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Service
import java.util.function.Function

@Service
class MongoItemProcessor(
    private val scoreCalculator: ScoreCalculator<Board>
): ItemProcessor<Board, Board> {

    override fun process(item: Board): Board? {
        println("id : ${item.id}")

        val newScore = scoreCalculator
            .calculate(item)

        item.score = newScore
        return item
    }

}