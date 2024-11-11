package fastcampus.kafka

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

const val BOOTSTRAP_SERVER = "localhost:9092"
const val TOPIC_NAME = "topic5"

fun main() {
    val config = mapOf(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to BOOTSTRAP_SERVER,
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.name,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.name,
        ProducerConfig.ACKS_CONFIG to "all",
        ProducerConfig.RETRIES_CONFIG to 3,
    )

    val message = "^_^!!!"

    KafkaProducer<String, String>(config).use { producer ->
        val record = ProducerRecord<String, String>(TOPIC_NAME, message)
        val metadata = producer.send(record).get()

        println(metadata)

        println("$message >> ${metadata.partition()} / ${metadata.offset()}")

        producer.flush()
        producer.close()
    }
}
