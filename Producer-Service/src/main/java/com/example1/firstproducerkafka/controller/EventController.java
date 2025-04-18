package com.example1.firstproducerkafka.controller;

import com.example1.firstproducerkafka.service.ServiceKafkaPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private ServiceKafkaPublisher publisher;

    @PostMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try{
            for(int i=0; i<=10;i++){
        publisher.sendToTopic(message + " " + i);
            }
        return ResponseEntity.ok("Message published");
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
