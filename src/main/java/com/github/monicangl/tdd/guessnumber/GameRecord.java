package com.github.monicangl.tdd.guessnumber;

import java.util.List;

public class GameRecord {
    private List<Integer> data;
    private String result;

    public GameRecord(List<Integer> data, String result) {
        this.data = data;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public List<Integer> getData() {
        return data;
    }
}
