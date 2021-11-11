package com.takeaway.divisiongame.messaging;

import com.takeaway.divisiongame.gameplay.StaticVariables;
import com.takeaway.divisiongame.model.GameState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @Autowired
    private Producer producer;

    @KafkaListener(topics = "#{'${game.kafka.topic.counter}'}", groupId = "group_id")
    public void consumeMessage(GameState gameState) {

        log.info("Consuming object: " + gameState.toString());
        StaticVariables.PLAYER_NUMBER = gameState.getPlayerNumber();
        if (gameState.getWinnerIndex() == 0) {
            this.producer.sendMessage("message");
        } else {
            log.info("End of messaging. Winner index: " + gameState.getWinnerIndex());
            System.out.println("Game Over. Winner is: " + gameState.getWinnerIndex());
        }
    }

}
