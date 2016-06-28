package com.github.monicangl.tdd.guessnumber;

public class GameDataInvalidException extends RuntimeException {
    public GameDataInvalidException(String message) {
        super(message);
    }
}
