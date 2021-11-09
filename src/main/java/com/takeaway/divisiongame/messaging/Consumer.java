package com.takeaway.divisiongame.messaging;

import com.takeaway.divisiongame.gameplay.StaticVariables;
import com.takeaway.divisiongame.model.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    private Producer producer;

    @KafkaListener(topics = "#{'${game.kafka.topic.counter}'}", groupId = "group_id")
    public void consumeMessage(GameState gameState) {

        StaticVariables.PLAYER_NUMBER = gameState.getPlayerNumber();
        this.producer.sendMessage("message");
        System.out.println(gameState.getPlayerNumber() + ", " + gameState.getModifier() + gameState.getWinnerIndex());
        System.out.println(gameState.toString());
    }

}
