package com.takeaway.divisiongame.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "p1_topic", groupId = "group_id")
    public void consumeMessage(String message) {

        System.out.println(message);
    }

}