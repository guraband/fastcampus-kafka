package fastcampus.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FastcampusKafkaApplication

fun main(args: Array<String>) {
    runApplication<FastcampusKafkaApplication>(*args)
}
