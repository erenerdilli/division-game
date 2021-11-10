package com.takeaway.divisiongame.gameplay;

import com.takeaway.divisiongame.messaging.Producer;
import com.takeaway.divisiongame.model.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private Producer producer;

    public void initGame() {
        StaticVariables.PLAYER_NUMBER = GameState.inceptNumberForStart();
        this.producer.sendMessage("Message");
        StaticVariables.START_OF_GAME = false;
    }
}
