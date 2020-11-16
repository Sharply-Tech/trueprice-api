package tech.sharply.trueprice.api.persistence.models.platforms

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "_platforms.platforms")
class Platform(
        @Id var id: String,
        @Indexed(unique = true) var code: String,
        @Indexed(unique = true) var website: String,
        var domains: Set<String>
) {

}