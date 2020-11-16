package tech.sharply.trueprice.api.persistence.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "_catalog.categories")
class ProductCategory(
        @Id var id: String,
        var title: String,
        @DBRef var parent: ProductCategory?,
        var keywords: Set<String>?
)