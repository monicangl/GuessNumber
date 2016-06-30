package com.github.monicangl.tdd.guessnumber.game.answer;

public class AnswerResult {
    private final boolean isRight;
    private final String message;

    AnswerResult(boolean isRight, String message) {
        this.isRight = isRight;
        this.message = message;
    }
    public boolean isRight() {
        return isRight;
    }
    public String getMessage() {
        return message;
    }
}
