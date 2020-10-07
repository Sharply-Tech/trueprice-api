package tech.sharply.trueprice.api.persistence.repositories.reviews

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import tech.sharply.trueprice.api.persistence.models.reviews.PlatformReview

@Repository
interface PlatformReviewRepository : MongoRepository<PlatformReview, String> {
}