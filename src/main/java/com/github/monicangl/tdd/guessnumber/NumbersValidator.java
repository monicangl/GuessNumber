package com.github.monicangl.tdd.guessnumber;

import java.util.List;

public class NumbersValidator {
    public boolean validate(List<Integer> numbers) {
        if (numbers.size() != 4) {
            return false;
        }

        Integer firstNumber = numbers.get(0);
        Integer secondNumber = numbers.get(1);
        Integer thirdNumber = numbers.get(2);
        Integer fourthNumber = numbers.get(3);

        if (firstNumber == secondNumber
                || firstNumber == thirdNumber
                || firstNumber == fourthNumber
                || secondNumber == thirdNumber
                || secondNumber == fourthNumber
                || thirdNumber == fourthNumber) {
            return false;
        }

        if ( (firstNumber < 0 || firstNumber > 9)
                || (secondNumber < 0 || secondNumber > 9)
                || (thirdNumber < 0 || thirdNumber > 9)
                || (fourthNumber < 0 || fourthNumber > 9)
                ) {
            return false;
        }

        return true;
    }
}
