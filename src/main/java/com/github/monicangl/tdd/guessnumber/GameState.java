package com.github.monicangl.tdd.guessnumber;

public class GameState {
    boolean isSuccessful = false;
    GameHistory history;

    public GameState() {
        history = new GameHistory();
    }
}
