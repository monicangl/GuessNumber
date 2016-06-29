package com.github.monicangl.tdd.guessnumber;

import java.util.HashSet;
import java.util.List;

public class AnswerValidator {
    private static final int countNumber = 4;
    private static final int numberBound = 10;

    public void validate(List<Integer> answer) {
        if (answer.size() != countNumber) {
            throw new AnswerInvalidException("The count of number is not" + countNumber);
        }
        if (new HashSet<>(answer).size() != countNumber) {
            throw new AnswerInvalidException("There are same answer");
        }
        for (Integer number : answer) {
            if (!(0 <= number && number < numberBound)) {
                throw new AnswerInvalidException("The number is not in right range");
            }
        }
    }
}
