package com.github.monicangl.tdd.guessnumber;

import org.junit.Test;

import java.util.Vector;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberGeneratorTest {
    @Test
    public void should_be_able_to_return_four_numbers() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when
        int numberCount = numberGenerator.generateNumbers().size();

        // then
        assertThat(numberCount, is(4));
    }

    @Test
    public void should_be_able_to_return_numbers_different() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when
        Vector<Integer> numbers = numberGenerator.generateNumbers();
        Integer firstNumber = numbers.elementAt(0);
        Integer secondNumber = numbers.elementAt(1);
        Integer thirdNumber = numbers.elementAt(2);
        Integer fourthNumber = numbers.elementAt(3);

        // then
        assertThat(firstNumber.equals(secondNumber), is(false));
        assertThat(firstNumber.equals(thirdNumber), is(false));
        assertThat(firstNumber.equals(fourthNumber), is(false));
        assertThat(secondNumber.equals(thirdNumber), is(false));
        assertThat(secondNumber.equals(fourthNumber), is(false));
        assertThat(thirdNumber.equals(fourthNumber), is(false));
    }
}
