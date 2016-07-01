package com.github.monicangl.tdd.guessnumber.game.answer.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.NUMBER_UPPER_BOUND;
import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.NUMBER_COUNT;
import static com.google.common.collect.Lists.newArrayList;

public class AnswerGenerator {
    public List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>(0);
        Random random = new Random();
        while (numbers.size() < NUMBER_COUNT) {
            numbers.add(random.nextInt(NUMBER_UPPER_BOUND + 1));
        }
        return newArrayList(numbers);
    }
}
