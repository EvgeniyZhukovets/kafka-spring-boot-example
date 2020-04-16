package ru.itis.kafka.consumers;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaTopicListener {

    @KafkaListener(topics = "${kafka.topic.title}", id = "simple-consumer")
    public void topicListener(String message) {
        log.info("Received a message: {}", message);
    }
}
