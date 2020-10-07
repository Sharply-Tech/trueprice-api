package tech.sharply.trueprice.api.persistence.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import tech.sharply.trueprice.api.persistence.models.PlatformProductOffer

@Repository
interface PlatformProductOfferRepository : MongoRepository<PlatformProductOffer, String>