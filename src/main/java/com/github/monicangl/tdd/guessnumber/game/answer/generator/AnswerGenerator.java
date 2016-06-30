package com.github.monicangl.tdd.guessnumber.game.answer.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.numberUpperBound;
import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.numberCount;
import static com.google.common.collect.Lists.newArrayList;

public class AnswerGenerator {
    public List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>(0);
        Random random = new Random();
        while (numbers.size() < numberCount) {
            numbers.add(random.nextInt(numberUpperBound + 1));
        }
        return newArrayList(numbers);
    }
}
