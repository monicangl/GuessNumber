package com.github.monicangl.tdd.guessnumber.game.answer.validator;

import com.github.monicangl.tdd.guessnumber.game.answer.exception.AnswerInvalidException;
import com.google.common.collect.Range;

import java.util.HashSet;
import java.util.List;

import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.numberLowerBound;
import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.numberUpperBound;
import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.numberCount;

public class AnswerValidator {
    public void validate(List<Integer> answer) {
        if (answer.size() != numberCount
                || new HashSet<>(answer).size() != numberCount
                || !Range.closed(numberLowerBound, numberUpperBound).containsAll(answer)) {
            throw new AnswerInvalidException("Invalid answer!");
        }
    }
}
