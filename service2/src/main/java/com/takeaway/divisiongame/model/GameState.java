package com.takeaway.divisiongame.model;

import com.takeaway.divisiongame.gameplay.StaticVariables;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameState {

    //@Value("${game.player.index}")
    private int PLAYER_INDEX = 1;

    private static final int LOWER_BOUND = 10;
    private static final int UPPER_BOUND = 1000;

    private int turn;
    private int playerNumber;
    private int modifier;
    private int winnerIndex;

    public GameState(int playerNumber) {
        if (StaticVariables.START_OF_GAME) {
            this.playerNumber = playerNumber;
        } else {
            this.playerNumber = nextWholeNumber(playerNumber);
        }

        if (this.playerNumber == 1) {
            this.winnerIndex = PLAYER_INDEX;
        }
        if (this.winnerIndex != 0)
            return;
        this.turn = (PLAYER_INDEX % 2) + 1;
    }


    /*
        Produce a random number to kick off the game.
     */
    public static int inceptNumberForStart() {
        int startingNumber = (int) Math.floor(Math.random() * (UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND);
        return startingNumber;
    }

    public void calculateModifier(int number) {
        if (number % 3 == 2) {
            this.modifier = 1;
        } else if (number % 3 == 1) {
            this.modifier = -1;
        } else {
            this.modifier = 0;
        }
    }

    public int nextWholeNumber(int number) {

        calculateModifier(number);
        number += this.modifier;
        number = number / 3;

        return number;
    }

    public boolean canPlay() {
        return this.turn == PLAYER_INDEX;
    }

    public static GameState getCurrentGameState(int playerNumber) {
        return new GameState(playerNumber);
    }

    public void makeMove(int playerNumber) {
        getCurrentGameState(playerNumber);
    }

}
