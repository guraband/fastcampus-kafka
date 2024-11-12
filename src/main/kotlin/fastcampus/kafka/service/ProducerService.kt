package fastcampus.kafka.service

import fastcampus.kafka.dto.Message
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ProducerService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val jsonKafkaTemplate: KafkaTemplate<String, Message>
) {

    companion object {
        const val TOPIC_NAME = "topic5"
    }

    fun send(message: String) {
        kafkaTemplate.send(TOPIC_NAME, message)
    }

    fun sendWithCallback(message: String) {
        val future = kafkaTemplate.send(TOPIC_NAME, message)

        future.whenComplete { result, exception ->
            if (exception == null) {
                println("Sent $message / offset : ${result.recordMetadata.offset()}")
            } else {
                println("Failed $message due to ${exception.message}")
            }
        }
    }

    fun sendJson(message: Message) {
        jsonKafkaTemplate.send(TOPIC_NAME, message)
    }
}