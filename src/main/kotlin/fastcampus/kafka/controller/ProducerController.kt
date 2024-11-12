package fastcampus.kafka.controller

import fastcampus.kafka.dto.Message
import fastcampus.kafka.service.ProducerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProducerController(
    private val producerService: ProducerService
) {
    @RequestMapping("/publish")
    fun publish(message: String): String {
        producerService.send(message)
        return "# 메시지 발행 완료 : $message"
    }

    @RequestMapping("/publish2")
    fun publishWithCallback(message: String): String {
        producerService.sendWithCallback(message)
        return "# 메시지 발행 완료 : $message"
    }

    @PostMapping("/publish3")
    fun publicJson(@RequestBody message: Message): String {
        producerService.sendJson(message)
        return "# 메시지 발행 완료 : $message"
    }
}