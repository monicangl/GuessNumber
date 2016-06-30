package com.github.monicangl.tdd.guessnumber.game.answer.generator;

import com.google.common.collect.Range;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static com.github.monicangl.tdd.guessnumber.game.answer.Constants.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnswerGeneratorTest {
    private AnswerGenerator numberGenerator = new AnswerGenerator();

    @Test
    public void should_be_able_to_return_four_different_numbers_from_0_to_9() {
        // when
        List<Integer> answer = numberGenerator.generate();

        // then
        assertThat(answer.size(), is(numberCount));
        assertThat(new HashSet<>(answer).size(), is(numberCount));
        assertThat(Range.closed(numberLowerBound, numberUpperBound).containsAll(answer), is(true));
    }


}
