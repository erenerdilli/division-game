package com.takeaway.divisiongame.messaging;

import com.takeaway.divisiongame.gameplay.StaticVariables;
import com.takeaway.divisiongame.model.GameState;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class Producer {
    @Value("${game.kafka.topic.self}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, GameState> kafkaTemplate;

    public void sendMessage(String message) {
        GameState gameState = new GameState(StaticVariables.PLAYER_NUMBER);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Writing object " + gameState.toString() + " to topic " + topic);
        System.out.println(gameState.toString());
        this.kafkaTemplate.send(topic, gameState);
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(topic, 3, (short) 1);
    }
}
