package com.github.monicangl.tdd.guessnumber;

public class AnswerInvalidException extends RuntimeException {
    public AnswerInvalidException(String message) {
        super(message);
    }
}
