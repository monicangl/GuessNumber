package com.github.monicangl.tdd.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {
    private static final int numberCount = 4;
    private static final int numberBound = 10;

    public Integer[] generate() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < numberCount) {
            int number = random.nextInt(numberBound);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        Integer[] answer = new Integer[numberCount];
        for (int i = 0; i < numberCount; ++i) {
            answer[i] = numbers.get(i);
        }

        return answer;
    }
}
