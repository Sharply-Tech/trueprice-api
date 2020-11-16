package tech.sharply.trueprice.api.env

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.net.URL

@Configuration
@ConfigurationProperties("scrapers")
class ScrapersServiceConf {
    var baseUrl: URL? = null
}