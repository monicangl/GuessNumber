package com.github.monicangl.tdd.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlayer {
    public void play(GuessNumberGame game) {
        while (!game.isOver()) {
            List<Integer> playerAnswer = guessAnswer();
            game.play(playerAnswer);
        }
    }

    private List<Integer> guessAnswer() {
        String[] numberArr = new Scanner(System.in).nextLine().split(" ");
        List<Integer> answer = new ArrayList<>(0);
        for (String aNumberArr : numberArr) {
            answer.add(Integer.valueOf(aNumberArr));
        }
        return answer;
    }
}
