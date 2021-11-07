package com.takeaway.divisiongame.messaging;

import com.takeaway.divisiongame.model.GameState;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Value("${game.kafka.topic.self}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, GameState> kafkaTemplate;

    public void sendMessage(String message) {
        this.kafkaTemplate.send(topic, new GameState(1, 50, 1, 0));
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(topic, 3, (short) 1);
    }
}
