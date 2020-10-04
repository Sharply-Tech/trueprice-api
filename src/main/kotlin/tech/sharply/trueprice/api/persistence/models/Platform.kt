package tech.sharply.trueprice.api.persistence.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="platforms")
class Platform(
        @Id var id: String,
        var website: String,
        var domains: Set<String>
) {

}