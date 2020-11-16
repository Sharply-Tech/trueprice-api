package tech.sharply.trueprice.api.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import tech.sharply.trueprice.api.persistence.repositories.ProductRepository
import tech.sharply.trueprice.api.persistence.repositories.platforms.PlatformRepository

@Service
class ScrapersService(@Autowired val productRepository: ProductRepository,
                      @Autowired val platformRepository: PlatformRepository) {



}