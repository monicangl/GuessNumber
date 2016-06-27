package com.github.monicangl.tdd.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {
    private static final int numberCount = 4;
    private static final int numberBound = 10;

    public List<Integer> generate() {
        List<Integer> answer = new ArrayList<>();
        Random random = new Random();
        while (answer.size() < numberCount) {
            int number = random.nextInt(numberBound);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }

        return answer;
    }
}
