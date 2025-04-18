package com.example1.firstproducerkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewTopicCreated {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("first-config-topic-1", 5, (short) 1);
    }
}
