package tech.sharply.trueprice.api.models

import java.time.LocalDateTime

class ProductScore(
        score: Double,
        noReviews: Int,
        createdAt: LocalDateTime,
        lastUpdatedAt: LocalDateTime
)