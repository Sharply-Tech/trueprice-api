package tech.sharply.trueprice.api.persistence.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import tech.sharply.trueprice.api.models.ProductScore

@Document(collection = "_catalog.products")
class Product(
        @Id var id: String,
        var gtin: String,
        var manufacturerCode: String,
        @DBRef var category: ProductCategory,
        var score: ProductScore
)