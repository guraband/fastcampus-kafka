package fastcampus.kafka.component

import fastcampus.kafka.dto.Message
import fastcampus.kafka.service.ProducerService.Companion.JSON_TOPIC_NAME
import fastcampus.kafka.service.ProducerService.Companion.TOPIC_NAME
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaConsumer {
    @KafkaListener(topics = [TOPIC_NAME], containerFactory = "kafkaListenerContainerFactory")
    fun listenMessage(message: String) {
        try {
            println(">>> $message")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @KafkaListener(topics = [JSON_TOPIC_NAME], containerFactory = "jsonKafkaListenerContainerFactory")
    fun listenJsonMessage(message: Message) {
        try {
            println(">>> $message")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}