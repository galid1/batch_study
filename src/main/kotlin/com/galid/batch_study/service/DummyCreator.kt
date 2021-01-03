package com.galid.batch_study.service

import com.galid.batch_study.model.Board
import com.galid.batch_study.repository.BoardRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class DummyCreator(
    val boardRepository: BoardRepository
) {
    fun create() {
        val random = java.util.Random()

        val boardList = mutableListOf<Board>()

        for (i in 0..20) {
            boardList.add(Board(
                id = ObjectId.get(),
                title = "HI",
                content = "Post !@!@!@",
                score = 0.0,
                readCount = random.nextInt(100),
                likeCount = random.nextInt(100),
                commentCount = random.nextInt(100)
            ))
        }

        boardRepository.saveAll(boardList)
    }

}