package com.example1.firstproducerkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ServiceKafkaPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendToTopic(String message) {
        CompletableFuture<SendResult<String, String>> future
                = kafkaTemplate.send("first-config-topic-1", message);

        future.whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("sent message = [" + message +
                        "] with offset [" + result.getRecordMetadata().offset() + "]");
            }else{
                System.out.println("failed to send message =[" + message + "] due to " + e.getMessage());
            }
        });
    }
}
