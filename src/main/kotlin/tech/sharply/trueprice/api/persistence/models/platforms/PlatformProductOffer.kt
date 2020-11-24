package tech.sharply.trueprice.api.persistence.models.platforms

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import tech.sharply.trueprice.api.persistence.models.Product
import java.math.BigDecimal

@Document(collection = "_platforms.offers")
class PlatformProductOffer(
        @Id var id: String? = null,
        @DBRef var product: Product? = null,
        @DBRef var platform: Platform? = null,
        var url: String? = null,
        var title: String? = null,
        var price: BigDecimal? = null,
        var oldPrice: BigDecimal? = null
        // TODO: Add stock info field
)