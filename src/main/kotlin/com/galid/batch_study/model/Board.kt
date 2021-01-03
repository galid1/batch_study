package com.galid.batch_study.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("board")
class Board (
    @Id
    var id: ObjectId? = null,
    var title: String? = null,
    var content: String? = null,
    var score: Double? = 0.0,
    var readCount: Int? = 0,
    var likeCount: Int? = 0,
    var commentCount: Int? = 0
) : BaseDocument()
