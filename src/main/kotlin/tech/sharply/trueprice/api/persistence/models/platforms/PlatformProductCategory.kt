package tech.sharply.trueprice.api.persistence.models.platforms

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import tech.sharply.trueprice.api.persistence.models.ProductCategory

@Document(collection = "_platforms.categories")
class PlatformProductCategory(
        @Id var id: String,
        var title: String,
        @DBRef var category: ProductCategory

)