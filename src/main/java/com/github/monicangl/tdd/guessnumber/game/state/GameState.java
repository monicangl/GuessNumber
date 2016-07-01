package com.github.monicangl.tdd.guessnumber.game.state;

import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private GameStatus status;
    private List<GameRecord> records;

    public void setStatus(GameStatus status) {
        this.status = status;
        if (status == GameStatus.RUNNING) {
            records.clear();
        }
    }

    public GameState(GameStatus status) {
        this.status = status;
        this.records = new ArrayList<>(0);
    }

    public void addRecord(List<Integer> playerAnswer, String message) {
        records.add(new GameRecord(playerAnswer, message));
    }

    public int playTimes() {
        return records.size();
    }

    public GameRecord getRecord(int time) {
        if (Range.closed(0, records.size() - 1).contains(time)) {
            return records.get(time);
        }
        return null;
    }

    public GameStatus getStatus() {
        return status;
    }
}
