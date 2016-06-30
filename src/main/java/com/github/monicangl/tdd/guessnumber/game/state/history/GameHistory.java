package com.github.monicangl.tdd.guessnumber.game.state.history;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {
    public void addRecord(GameRecord record) {
        records.add(record);
    }

    public int getPlayTimes() {
        return records.size();
    }

    public List<Integer> getPlayData(int time) {
        if (time >= records.size()) {
            return null;
        }
        return (records.get(time)).getAnswer();
    }

    public String getPlayResult(int time) {
        if (time >= records.size()) {
            return null;
        }
        return (records.get(time)).getResult();
    }

    private List<GameRecord> records = new ArrayList<>(0);
}

