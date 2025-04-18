package com.example1.firstkafkaconsumer.FirstKafkaServiceConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceConsumer {

    //adding the comments
    //New comments from feature branch
    //few more
    @KafkaListener(topics = "first-config-topic-1", groupId = "my-consumer-group")
    public void consumeMessage(String message) {
        System.out.println("Consumed this new message: " + message);
    }
}
