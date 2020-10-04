package tech.sharply.trueprice.api.models

class ProductAvailability(availability: ProductAvailabilityType,
                          itemsLeftOnStock: Int)

enum class ProductAvailabilityType {

    AVAILABLE,
    UNAVAILABLE,
    PRE_ORDER;

}