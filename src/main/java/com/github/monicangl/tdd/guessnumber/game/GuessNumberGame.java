package com.github.monicangl.tdd.guessnumber.game;

import com.github.monicangl.tdd.guessnumber.game.answer.Answer;
import com.github.monicangl.tdd.guessnumber.game.answer.AnswerResult;
import com.github.monicangl.tdd.guessnumber.game.state.GameState;
import com.github.monicangl.tdd.guessnumber.game.state.GameStatus;
import com.github.monicangl.tdd.guessnumber.game.state.history.GameHistory;
import com.github.monicangl.tdd.guessnumber.game.state.history.GameRecord;
import com.google.inject.Inject;

import java.util.List;

public class GuessNumberGame {
    private Answer answer;
    private GameState gameState;
    private static final int chance = 6;

    @Inject
    public GuessNumberGame(Answer answer) {
        this.answer = answer;
    }

    public void play(List<Integer> playerAnswer) {
        AnswerResult result = answer.guess(playerAnswer);
        gameState.history.addRecord(new GameRecord(playerAnswer, result.getMessage()));
        gameState.status = result.isRight() ? GameStatus.SUCCESS : gameState.status;
        System.out.println(result.getMessage());
    }

    public void start() {
        gameState = new GameState(GameStatus.RUNNING);
        answer.initAnswer();
        System.out.println("你有六次猜测机会, 请输入答案, 以空格分隔数字:");
    }

    public boolean isOver() {
        return gameState.status == GameStatus.SUCCESS
                || gameState.history.getPlayTimes() == chance;
    }

    public String getResult() {
        if (gameState.status == GameStatus.SUCCESS) {
            return "全中,胜出";
        }

        return "六次未猜中,游戏失败";
    }

    GameHistory getHistory() {
        return gameState.history;
    }

//    public void play(GamePlayer gamePlayer) {
//        start();
//        System.out.println("你有六次猜测机会, 请输入答案, 以空格分隔数字:");
//        while (!isOver()) {
//            play(gamePlayer.answer());
//        }
//    }
}
