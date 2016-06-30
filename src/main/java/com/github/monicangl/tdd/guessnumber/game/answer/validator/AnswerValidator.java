package com.github.monicangl.tdd.guessnumber.game.answer.validator;

import com.github.monicangl.tdd.guessnumber.game.answer.exception.AnswerInvalidException;

import java.util.HashSet;
import java.util.List;

import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.numberBound;
import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.numberCount;

public class AnswerValidator {
    public void validate(List<Integer> answer) {
        if (answer.size() != numberCount) {
            throw new AnswerInvalidException("The count of number is not" + numberCount);
        }
        if (new HashSet<>(answer).size() != numberCount) {
            throw new AnswerInvalidException("There are same answer");
        }
        for (Integer number : answer) {
            if (!(0 <= number && number < numberBound)) {
                throw new AnswerInvalidException("The number is not in right range");
            }
        }
    }
}
