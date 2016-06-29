package com.github.monicangl.tdd.guessnumber;

import javafx.util.Pair;
import java.util.Arrays;

public class Answer {
    private final AnswerValidator validator;
    private Integer[] answer;

    public Answer(AnswerValidator validator) {
        this.validator = validator;
    }

    public Pair<Boolean, String> check(Integer[] playerAnswer) {
        if (!validatePlayerAnswer(playerAnswer)) {
            return new Pair<>(false, "输入不正确，重新输入");
        }
        int countOfRightNumberOnRightPosition = 0;
        int countOfRightNumberOnWrongPosition = 0;
        boolean success = false;
        if (isCorrect(answer, playerAnswer)) {
            success = true;
            countOfRightNumberOnRightPosition = answer.length;
        } else {
            countOfRightNumberOnRightPosition = checkRightNumberOnRightPosition(playerAnswer);
            countOfRightNumberOnWrongPosition = checkRightNumberOnWrongPosition(playerAnswer);
        }
        return new Pair<>(success, countOfRightNumberOnRightPosition + "A" + countOfRightNumberOnWrongPosition + "B");
    }

    private boolean validatePlayerAnswer(Integer[] numbers) {
        try {
            validator.validate(numbers);
        }
        catch (AnswerInvalidException exception) {
            return false;
        }

        return true;
    }

    private int checkRightNumberOnRightPosition(Integer[] playerAnwser) {
        int countOfRightNumberOnRightPosition = 0;
        for (int i = 0; i < playerAnwser.length; ++i) {
            Integer number = playerAnwser[i];
            if (number.equals(answer[i])) {
                ++countOfRightNumberOnRightPosition;
            }
        }
        return countOfRightNumberOnRightPosition;
    }

    private int checkRightNumberOnWrongPosition(Integer[] playerAnwser) {
        int countOfRightNumberOnWrongPosition = 0;
        for (int i = 0; i < playerAnwser.length; ++i) {
            Integer number = playerAnwser[i];
            if (!number.equals(answer[i])) {
                for (Integer anAnswer : answer) {
                    if (number.equals(anAnswer)) {
                        ++countOfRightNumberOnWrongPosition;
                        break;
                    }
                }
            }
        }
        return countOfRightNumberOnWrongPosition;
    }

    private boolean isCorrect(Integer[] answer, Integer[] playerAnswer) {
        return Arrays.equals(playerAnswer, answer);
    }

    public void setAnswer(Integer[] answer) {
        this.answer = answer;
    }
}
