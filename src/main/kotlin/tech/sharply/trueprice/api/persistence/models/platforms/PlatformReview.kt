package tech.sharply.trueprice.api.persistence.models.platforms

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection="_platforms.reviews")
class PlatformReview (
        @Id var id: String,
        var score: Double,
        var createdBy: String, // TODO: User identity class
        var createdAt: LocalDateTime
) 