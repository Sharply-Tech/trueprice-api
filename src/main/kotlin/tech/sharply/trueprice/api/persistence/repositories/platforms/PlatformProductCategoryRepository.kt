package tech.sharply.trueprice.api.persistence.repositories.platforms

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import tech.sharply.trueprice.api.persistence.models.platforms.PlatformProductCategory

@Repository
interface PlatformProductCategoryRepository : MongoRepository<PlatformProductCategory, String> {

    fun findByCode(code: String): PlatformProductCategory

    fun findByUrl(url: String): PlatformProductCategory

}