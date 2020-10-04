package tech.sharply.trueprice.api.models

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

class ProductScore(
        score: Double,
        noReviews: Int,
        createdAt: LocalDateTime,
        lastUpdatedAt: LocalDateTime
)