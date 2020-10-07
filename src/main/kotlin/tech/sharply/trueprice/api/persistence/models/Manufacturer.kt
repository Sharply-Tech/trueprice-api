package tech.sharply.trueprice.api.persistence.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("_general.manufacturers")
class Manufacturer {
    @Id
    var id: String? = null
    var name: String? = null
    var keywords: Set<String>? = null
}