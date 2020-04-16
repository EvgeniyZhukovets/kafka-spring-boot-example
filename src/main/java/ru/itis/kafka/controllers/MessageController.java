package ru.itis.kafka.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/{message}")
    public String helloKafka(@PathVariable String message) {
        kafkaTemplate.send("topic", message);
        log.info("Send message: {}", message);
        return "Message " + message + " send";
    }


}
