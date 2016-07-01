package com.github.monicangl.tdd.guessnumber.game.answer.validator;

import com.github.monicangl.tdd.guessnumber.game.answer.exception.AnswerInvalidException;
import com.google.common.collect.Range;

import java.util.HashSet;
import java.util.List;

import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.NUMBER_LOWER_BOUND;
import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.NUMBER_UPPER_BOUND;
import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.NUMBER_COUNT;

public class AnswerValidator {
    public void validate(List<Integer> answer) {
        if (answer.size() != NUMBER_COUNT
                || new HashSet<>(answer).size() != NUMBER_COUNT
                || !Range.closed(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND).containsAll(answer)) {
            throw new AnswerInvalidException("Invalid answer!");
        }
    }
}
