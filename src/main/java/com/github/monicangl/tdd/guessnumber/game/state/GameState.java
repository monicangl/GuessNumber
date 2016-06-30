package com.github.monicangl.tdd.guessnumber.game.state;

import com.github.monicangl.tdd.guessnumber.game.state.history.GameHistory;

public class GameState {
    public GameStatus status;
    public GameHistory history;

    public GameState(GameStatus status) {
        this.status = status;
        this.history = new GameHistory();
    }
}
