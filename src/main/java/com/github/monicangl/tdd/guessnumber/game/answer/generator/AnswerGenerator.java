package com.github.monicangl.tdd.guessnumber.game.answer.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;

public class AnswerGenerator {
    private static final int numberCount = 4;
    private static final int numberBound = 10;

    public List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>(0);
        Random random = new Random();
        while (numbers.size() < numberCount) {
            numbers.add(random.nextInt(numberBound));
        }
        List<Integer> answer = newArrayList(numbers);
        return answer;
    }
}
