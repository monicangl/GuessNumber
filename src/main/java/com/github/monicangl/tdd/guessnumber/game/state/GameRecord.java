package com.github.monicangl.tdd.guessnumber.game.state;

import java.util.List;

public class GameRecord {
    private List<Integer> answer;
    private String message;

    public GameRecord(List<Integer> answer, String message) {
        this.answer = answer;
        this.message = message;
    }

    public String getResult() {
        return message;
    }
    public List<Integer> getAnswer() {
        return answer;
    }
}
