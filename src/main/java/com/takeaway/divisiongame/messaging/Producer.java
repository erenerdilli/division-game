package com.takeaway.divisiongame.messaging;

import com.takeaway.divisiongame.model.GameState;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String TOPIC = "p1_topic";

    @Autowired
    private KafkaTemplate<String, GameState> kafkaTemplate;

    public void sendMessage(String message) {
        this.kafkaTemplate.send(TOPIC, new GameState(1, 50, 1, 0));
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(TOPIC, 3, (short) 1);
    }
}
