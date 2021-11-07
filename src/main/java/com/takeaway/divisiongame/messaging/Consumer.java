package com.takeaway.divisiongame.messaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "#{'${game.kafka.topic.counter}'}", groupId = "group_id")
    public void consumeMessage(String message) {

        System.out.println(message);
    }

}
