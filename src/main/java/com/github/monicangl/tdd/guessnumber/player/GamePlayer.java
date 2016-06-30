package com.github.monicangl.tdd.guessnumber.player;

import com.github.monicangl.tdd.guessnumber.game.GuessNumberGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlayer {
    public void play(GuessNumberGame game) {
//        game.play(this);
        do {
            game.play(answer());
        }
        while (!game.isOver());
    }

    public List<Integer> answer() {
        String[] numberArr = new Scanner(System.in).nextLine().split(" ");
        List<Integer> answer = new ArrayList<>(0);
        for (String aNumberArr : numberArr) {
            answer.add(Integer.valueOf(aNumberArr));
        }
        return answer;
    }
}
