package com.takeaway.divisiongame.gameplay;

import com.takeaway.divisiongame.messaging.Producer;
import com.takeaway.divisiongame.model.GameState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GameService {

    @Autowired
    private Producer producer;

    public void initGame() {
        StaticVariables.PLAYER_NUMBER = GameState.inceptNumberForStart();
        log.info("Init was called. Random number is: " + StaticVariables.PLAYER_NUMBER);
        this.producer.sendMessage("Message");
        StaticVariables.START_OF_GAME = false;
    }
}
