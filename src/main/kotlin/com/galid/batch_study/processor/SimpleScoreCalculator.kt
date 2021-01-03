package com.galid.batch_study.processor

import com.galid.batch_study.model.Board
import org.springframework.stereotype.Service

@Service
class SimpleScoreCalculator: ScoreCalculator<Board> {

    override fun calculate(board: Board): Double {
        

        return 2.0
    }
}