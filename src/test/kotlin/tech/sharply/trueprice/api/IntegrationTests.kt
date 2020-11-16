package tech.sharply.trueprice.api

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    // there is no static keyword for methods in kotlin. This is how we declare static functions
    companion object {
        @BeforeAll
        fun setup() {
            println(">> Setup")
        }

        @AfterAll
        fun teardown() {
            println(">> Tear down")
        }
    }


    @Test
    fun `Assert products list and status code`() {
        println(">> Assert products list and status code")
        val entity = restTemplate.getForEntity<String>("/")
        assert(entity.statusCode == HttpStatus.OK)
    }

    @Test
    fun `Assert article page title, content and status code`() {
        println(">> Assert article page title, content and status code")
        val title = "Reactor Aluminium has landed"
        val entity = restTemplate.getForEntity<String>("/article/${title}")
        assert(entity.statusCode == HttpStatus.OK)
    }
}