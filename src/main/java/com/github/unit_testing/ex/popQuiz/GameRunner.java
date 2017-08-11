package com.github.unit_testing.ex.popQuiz;

import java.util.Random;


public class GameRunner {

    public static void main(String[] args) {
        Random rand = new Random();
        runGame(rand);
    }

    public static void runGame(Random rand) {
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        boolean notAWinner;
        do {
            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }

        } while (notAWinner);
    }
}
