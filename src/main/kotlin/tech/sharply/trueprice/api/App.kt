package tech.sharply.trueprice.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class App {
	@Bean
	fun rest() = RestTemplate()
}

fun main(args: Array<String>) {
	runApplication<App>(*args)
}
