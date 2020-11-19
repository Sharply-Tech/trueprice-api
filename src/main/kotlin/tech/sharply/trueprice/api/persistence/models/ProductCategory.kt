package tech.sharply.trueprice.api.persistence.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "_catalog.categories")
class ProductCategory(
        @Id var id: String? = null,
        @Indexed(unique = true) var code: String,
        var title: String? = null,
        @DBRef var parent: ProductCategory? = null,
        var keywords: Set<String>? = null
)