package tech.sharply.trueprice.api.persistence.repositories.platforms

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import tech.sharply.trueprice.api.persistence.models.platforms.Platform

@Repository
interface PlatformRepository : MongoRepository<Platform, String>