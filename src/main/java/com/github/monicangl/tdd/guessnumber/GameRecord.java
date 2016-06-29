package com.github.monicangl.tdd.guessnumber;

public class GameRecord {
    private Integer[] data;
    private String result;

    public GameRecord(Integer[] data, String result) {
        this.data = data;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public Integer[] getData() {
        return data;
    }
}
