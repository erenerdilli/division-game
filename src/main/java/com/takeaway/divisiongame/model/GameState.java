package com.takeaway.divisiongame.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameState {

    private static final int LOWER_BOUND = 10;
    private static final int UPPER_BOUND = 10000;

    private int playerIndex;
    private int playerNumber;
    private int modifier;
    private int winnerIndex;


    /*
        Produce a random number to kick off the game.
     */
    public void inceptNumberForStart() {
        int startingNumber = (int) Math.floor(Math.random() * (UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND);
        this.playerNumber = startingNumber;
    }

    public int nextWholeNumber(int number) {

        if (number % 3 == 2) {
            number++;
        } else if (number % 3 == 1) {
            number--;
        }

        number = number / 3;

        return number;
    }

}
