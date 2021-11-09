package com.takeaway.divisiongame.controller;

import com.takeaway.divisiongame.gameplay.GameService;
import com.takeaway.divisiongame.messaging.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GamePlayController {

    private final Producer producer;
    private final GameService gameService;

//    @Autowired
//    public GamePlayController(Producer producer) {
//        this.producer = producer;
//    }

    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }

    @PostMapping("/init")
    public void initGame() {
        gameService.initGame();
    }


}
