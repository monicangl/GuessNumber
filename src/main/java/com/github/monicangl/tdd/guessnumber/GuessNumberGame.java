package com.github.monicangl.tdd.guessnumber;

import javafx.util.Pair;

import java.util.List;

public class GuessNumberGame {
    private Answer answer;
    private GameState gameState;
    private static final int chance = 6;

    public GuessNumberGame(Answer answer) {
        this.answer = answer;
    }

    public void play(List<Integer> playerAnswer) {
        Pair<Boolean, String> result = answer.check(playerAnswer);
        gameState.history.addRecord(new GameRecord(playerAnswer, result.getValue()));
        gameState.isSuccessful = result.getKey();
        System.out.println(result.getValue());
    }

    public GameHistory getHistory() {
        return gameState.history;
    }

    public void start() {
        gameState = new GameState();
        answer.initAnswer();
        System.out.println("你有六次猜测机会, 请输入答案, 以空格分隔数字:");
    }

    public boolean isOver() {
        return gameState.isSuccessful || gameState.history.getPlayTimes() == chance;
    }

    public String getResult() {
        if (gameState.isSuccessful) {
            return "全中,胜出";
        }

        return "六次未猜中,游戏失败";
    }
}
