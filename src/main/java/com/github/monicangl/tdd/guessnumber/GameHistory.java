package com.github.monicangl.tdd.guessnumber;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {
    public void addRecord(GameRecord record) {
        records.add(record);
    }

    public int getPlayTimes() {
        return records.size();
    }

    public Integer[] getPlayData(int time) {
        if (time >= records.size()) {
            return null;
        }
        return (records.get(time)).getData();
    }

    public String getPlayResult(int time) {
        if (time >= records.size()) {
            return null;
        }
        return (records.get(time)).getResult();
    }

    private List<GameRecord> records = new ArrayList<>(0);
}

