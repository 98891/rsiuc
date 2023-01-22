package pl.uz.rsiuc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RsiucApplication

fun main(args: Array<String>) {
	runApplication<RsiucApplication>(*args)
}
