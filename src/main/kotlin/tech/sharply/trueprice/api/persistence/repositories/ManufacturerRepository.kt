package tech.sharply.trueprice.api.persistence.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import tech.sharply.trueprice.api.persistence.models.Manufacturer

@Repository
interface ManufacturerRepository : MongoRepository<Manufacturer, String> {
}