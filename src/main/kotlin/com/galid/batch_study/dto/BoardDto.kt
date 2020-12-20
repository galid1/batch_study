package com.galid.batch_study.dto

import org.bson.types.ObjectId
import java.time.LocalDateTime

class BoardDto {
    data class BoardRequest (
        val title: String?,
        val content: String?,
    )

    data class BoardResponse(
        val id: ObjectId? = null,
        val title: String? = null,
        val content: String? = null,
        val createdAt: LocalDateTime? = null,
        val updatedAt: LocalDateTime? = null
    )
}