package tech.sharply.trueprice.api.persistence.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import tech.sharply.trueprice.api.persistence.models.ProductCategory
import tech.sharply.trueprice.api.persistence.repositories.ProductCategoryRepository
import tech.sharply.trueprice.api.services.ScrapersService

/**
 * Automatically configures the system's categories.
 * The source of categories will be one of the most used platforms registered,
 * for the time being that is [emag.ro](https://www.emag.ro)
 */
@Service
class ProductCategoryService(
        @Autowired val productCategoryRepository: ProductCategoryRepository,
        @Autowired val scrapersService: ScrapersService
) {
    private val LOG: Logger = LoggerFactory.getLogger(javaClass)

    companion object {
        private const val SOURCE_OF_TRUTH_PLATFORM_CODE = "emag"
    }

    /**
     * This method uses the configured SOURCE OF TRUTH PLATFORM to register categories into the system.
     * Updating of platform categories is done independently for each platform by another task.
     */
    @Scheduled(cron = "0 2 * * MON")
    fun configureSystemProductCategories() {
        // Fetch the categories from the source of truth
        LOG.info("Configuring system product categories, considering the source of truth: $SOURCE_OF_TRUTH_PLATFORM_CODE")

        val categoriesResponse = scrapersService.getProductCategories(SOURCE_OF_TRUTH_PLATFORM_CODE)
        if (categoriesResponse.categories.isEmpty()) {
            LOG.error("The scrapers api returned no categories for source of truth: $SOURCE_OF_TRUTH_PLATFORM_CODE");
        }
        LOG.info("Scrapers API return ${categoriesResponse.categories.count()} categories, time effort to fetch categories ${categoriesResponse.timeEffort}")

        val newCategories = ArrayList<ProductCategory>()

        // the categories in our system will use the same codes as the ones fetched from the source of truth
        categoriesResponse.categories.forEach {
            // check if this category already exists in the repository
            if (productCategoryRepository.findByCode(it.code) != null) {
                return@forEach
            }
            try {
                val newCategory = ProductCategory(code = it.code, title = it.name)
                productCategoryRepository.save(newCategory);
                newCategories.add(newCategory)
            } catch (ex: Exception) {
                LOG.error("Could not insert category: ${it.code}", ex)
            }
        }
        if (newCategories.isEmpty()) {
            LOG.info("No new categories found.")
        } else {
           LOG.info("Registered ${newCategories.size} new categories!")
        }
    }
}