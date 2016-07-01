package com.github.monicangl.tdd.guessnumber.game;

import com.github.monicangl.tdd.guessnumber.game.answer.Answer;
import com.github.monicangl.tdd.guessnumber.game.answer.AnswerResult;
import com.github.monicangl.tdd.guessnumber.game.state.GameState;
import com.github.monicangl.tdd.guessnumber.game.state.GameStatus;
import com.github.monicangl.tdd.guessnumber.game.state.GameRecord;
import com.google.inject.Inject;

import java.util.List;

public class GuessNumberGame {
    private Answer answer;
    private GameState gameState;
    private static final int CHANCE = 6;

    @Inject
    public GuessNumberGame(Answer answer) {
        this.answer = answer;
        this.gameState = new GameState(GameStatus.NOT_START);
    }

    public void play(List<Integer> playerAnswer) {
        AnswerResult result = answer.guess(playerAnswer);
        System.out.println(result.getMessage());
        updateState(playerAnswer, result);
    }

    private void updateState(List<Integer> playerAnswer, AnswerResult result) {
        gameState.addRecord(playerAnswer, result.getMessage());
        if (result.isRight()) {
            gameState.setStatus(GameStatus.SUCCESS);
            System.out.println("全中,胜出");
        }
        else if (gameState.playTimes() == CHANCE) {
            gameState.setStatus(GameStatus.FAIL);
            System.out.println("六次未猜中,游戏失败");
        }
    }

    public void start() {
        gameState.setStatus(GameStatus.RUNNING);;
        answer.initialize();
        System.out.println("你有六次猜测机会, 请输入答案, 以空格分隔数字:");
    }

    public boolean isOver() {
        return gameState.getStatus() == GameStatus.SUCCESS
                || gameState.getStatus() == GameStatus.FAIL;
    }

    public GameStatus gameStatus() {
        return gameState.getStatus();
    }

    public int playTimes() {
        return gameState.playTimes();
    }

    public GameRecord getRecord(int time) {
        return gameState.getRecord(time);
    }

//    public void play(GamePlayer gamePlayer) {
//        start();
//        System.out.println("你有六次猜测机会, 请输入答案, 以空格分隔数字:");
//        while (!isOver()) {
//            play(gamePlayer.answer());
//        }
//    }
}
