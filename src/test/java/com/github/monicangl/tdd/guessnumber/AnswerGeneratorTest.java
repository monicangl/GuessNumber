package com.github.monicangl.tdd.guessnumber;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnswerGeneratorTest {
    private AnswerGenerator numberGenerator = new AnswerGenerator();

    @Test
    public void should_be_able_to_return_four_different_numbers_from_0_to_9() {
        // when
        List<Integer> answer =  numberGenerator.generate();
        Set<Integer> diffNumbers = new HashSet<>(0);
        diffNumbers.addAll(answer);

        // then
        assertThat(answer.size(), is(4));
        assertThat(diffNumbers.size(), is(4));
        //assertThat(answer, not(hasItem()));
    }
}
