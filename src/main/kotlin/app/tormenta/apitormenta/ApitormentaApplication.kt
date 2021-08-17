package app.tormenta.apitormenta

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ApitormentaApplication

fun main(args: Array<String>) {
	runApplication<ApitormentaApplication>(*args)
}
