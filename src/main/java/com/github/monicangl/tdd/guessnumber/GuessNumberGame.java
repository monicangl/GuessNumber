package com.github.monicangl.tdd.guessnumber;

import java.util.List;

public class GuessNumberGame {
    private Integer[] answer;
    private GameHistory history;
    private AnswerGenerator answerGenerator;
    private PlayerAnswerValidator validator;
    private boolean isSuccessful;

    public GuessNumberGame(final AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
        answer = this.answerGenerator.generate();
        history = new GameHistory();
        validator = new PlayerAnswerValidator();
    }

    public String play(Integer... numbers) {
        isSuccessful = false;
        try {
            validator.validate(numbers);
        }
        catch (GameDataInvalidException exception) {
            return "输入不正确，重新输入";
        }

        String result;
        if (numbers.equals(answer)) {
            isSuccessful = true;
            result = "0A4B";
        }
        else {
            int rightPositionNumberCount = 0;
            int wrongPositionNumberCount = 0;

            for (int i = 0; i < numbers.length; ++i) {
                Integer number = numbers[i];
                if (number.equals(answer[i])) {
                    ++rightPositionNumberCount;
                }
                else {
                    for (Integer anAnswer : answer) {
                        if (number.equals(anAnswer)) {
                            ++wrongPositionNumberCount;
                            break;
                        }
                    }
                }
            }

//            for (int i = 0; i < numbers.size(); ++i) {
//
//            }
//                if (this.answer.contains(numbers.get(i))) {
//                    if (numbers.get(i).equals(this.answer.get(i))) {
//                        ++rightPositionNumberCount;
//                    } else {
//                        ++wrongPositionNumberCount;
//                    }
//                }
//            }

            result = rightPositionNumberCount + "A" + wrongPositionNumberCount + "B";
        }

        history.addRecord(new GameRecord(numbers, result));

        return result;
    }

    public String promptError() {
        return "输入不正确，重新输入";
    }

    public GameHistory getHistory() {
        return history;
    }

    public void newGame() {
        history.clearRecord();
        answer = answerGenerator.generate();
        System.out.println();
    }

    public boolean getResult() {
        return isSuccessful;
    }
}
