package com.github.monicangl.tdd.guessnumber;

import java.util.ArrayList;
import java.util.List;

public class GuessNumberGame {
    private List<Integer> numbers;
    private List<String> guessRecord = new ArrayList<>(0);

    public GuessNumberGame() {
        numbers = new NumberGenerator().generateNumbers();
    }

    public List<String> guessRecord() {
        return guessRecord;
    }

    public String guess(List<Integer> guessNumbers) {
        NumbersValidator validator = new NumbersValidator();
        if (!validator.validate(guessNumbers)) {
            addGuessRecord(guessNumbers, "输入不正确，重新输入");
            return "输入不正确，重新输入";
        }

        return guessResult(guessNumbers);
    }

    private String guessResult(List<Integer> guessNumbers) {
        int rightPositionNumberCount = 0;
        int wrongPositionNumberCount = 0;
        String result;

        if (guessNumbers.equals(this.numbers)) {
            result = "4A0B";
        }
        else {
            for (int i = 0; i < guessNumbers.size(); ++i) {
                if (this.numbers.contains(guessNumbers.get(i))) {
                    if (guessNumbers.get(i) == this.numbers.get(i)) {
                        ++rightPositionNumberCount;
                    } else {
                        ++wrongPositionNumberCount;
                    }
                }
            }

            result = rightPositionNumberCount + "A" + wrongPositionNumberCount + "B";
        }


        addGuessRecord(guessNumbers, result);
        return result;
    }

    private void addGuessRecord(List<Integer> numbers, String result) {
        String record = numbers.toString();
        record = record.substring(1, record.length() - 1);
        record = record.replace(",", "");
        record = record.concat(" " + result);

        guessRecord.add(record);
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
