package com.github.monicangl.tdd.guessnumber;

import java.util.Scanner;

public class GamePlayer {
    public void play(GuessNumberGame game) {
        while (!game.isOver()) {
            Integer[] playerAnswer = guessAnswer();
            game.play(playerAnswer);
        }
    }

    private Integer[] guessAnswer() {
        String[] numberArr = new Scanner(System.in).nextLine().split(" ");
        Integer[] answer = new Integer[numberArr.length];
        for (int i = 0; i < numberArr.length; ++i) {
            answer[i] = Integer.valueOf(numberArr[i]);
        }
        return answer;
    }
}
