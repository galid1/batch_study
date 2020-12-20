package com.galid.batch_study.repository

import com.galid.batch_study.model.Board
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface BoardRepository: MongoRepository<Board, ObjectId> {
}