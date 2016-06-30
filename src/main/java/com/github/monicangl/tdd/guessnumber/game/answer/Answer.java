package com.github.monicangl.tdd.guessnumber.game.answer;

import com.github.monicangl.tdd.guessnumber.game.answer.exception.AnswerInvalidException;
import com.github.monicangl.tdd.guessnumber.game.answer.generator.AnswerGenerator;
import com.github.monicangl.tdd.guessnumber.game.answer.validator.AnswerValidator;
import com.google.inject.Inject;

import java.util.List;

public class Answer {
    private final AnswerGenerator generator;
    private final AnswerValidator validator;
    private List<Integer> answer;

    @Inject
    public Answer(AnswerGenerator generator, AnswerValidator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public void initAnswer() {
        this.answer = generator.generate();
    }

    public AnswerResult guess(List<Integer> playerAnswer) {
        if (!validatePlayerAnswer(playerAnswer)) {
            return new AnswerResult(false, "输入不正确，重新输入");
        }
        int countOfRightNumberOnRightPosition = this.countOfRightNumberOnRightPosition(playerAnswer);
        int countOfRightNumberOnWrongPosition = this.countOfRightNumberOnWrongPosition(playerAnswer);
        boolean success = countOfRightNumberOnRightPosition == playerAnswer.size();
        return new AnswerResult(success, countOfRightNumberOnRightPosition + "A" + countOfRightNumberOnWrongPosition + "B");
    }

    private boolean validatePlayerAnswer(List<Integer> answer) {
        try {
            validator.validate(answer);
        }
        catch (AnswerInvalidException exception) {
            return false;
        }
        return true;
    }

    private int countOfRightNumberOnRightPosition(List<Integer> playerAnswer) {
        int countOfRightNumberOnRightPosition = 0;
        for (int number : playerAnswer) {
            if (answer.contains(number) && answer.indexOf(number) == playerAnswer.indexOf(number)) {
                ++countOfRightNumberOnRightPosition;
            }
        }
        return countOfRightNumberOnRightPosition;
    }

    private int countOfRightNumberOnWrongPosition(List<Integer> playerAnswer) {
        int countOfRightNumberOnWrongPosition = 0;
        for (int number : playerAnswer) {
            if (answer.contains(number) && answer.indexOf(number) != playerAnswer.indexOf(number)) {
                ++countOfRightNumberOnWrongPosition;
            }
        }
        return countOfRightNumberOnWrongPosition;
    }
}
