package com.github.monicangl.tdd.guessnumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameDataValidator {
    private static final int countNumber = 4;
    private static final int numberBound = 10;

    public void validate(List<Integer> numbers) {
        if (numbers.size() != countNumber) {
            throw new GameDataInvalidException("The count of number is not" + countNumber);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(0);
        uniqueNumbers.addAll(numbers);

        if (uniqueNumbers.size() != countNumber) {
            throw new GameDataInvalidException("There are same numbers");
        }

        for (Integer number : numbers) {
            if (!(0 <= number && number < numberBound)) {
                throw new GameDataInvalidException("The number is not in right range");
            }
        }
    }
}
