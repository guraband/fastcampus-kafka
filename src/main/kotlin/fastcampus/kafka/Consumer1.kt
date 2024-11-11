package fastcampus.kafka

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration

const val GROUP_ID = "group1"

fun main() {
    val config = mapOf(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to BOOTSTRAP_SERVER,
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java.name,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java.name,
        ConsumerConfig.GROUP_ID_CONFIG to GROUP_ID,
        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest",
    )

    KafkaConsumer<String, String>(config).use { consumer ->
        consumer.subscribe(listOf(TOPIC_NAME))

        while (true) {
            val records = consumer.poll(Duration.ofSeconds(1))
            records.forEach {
                println(it)
            }
        }
    }
}