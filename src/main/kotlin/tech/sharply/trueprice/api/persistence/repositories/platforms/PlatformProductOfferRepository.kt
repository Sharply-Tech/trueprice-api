package tech.sharply.trueprice.api.persistence.repositories.platforms

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import tech.sharply.trueprice.api.persistence.models.platforms.Platform
import tech.sharply.trueprice.api.persistence.models.platforms.PlatformProductOffer
import java.util.*

@Repository
interface PlatformProductOfferRepository : MongoRepository<PlatformProductOffer, String> {

    fun findByPlatformAndUrl(platform: Platform, url: String): Optional<PlatformProductOffer>

}