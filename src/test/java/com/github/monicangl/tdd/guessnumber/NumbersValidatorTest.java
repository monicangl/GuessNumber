package com.github.monicangl.tdd.guessnumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumbersValidatorTest {
    private NumbersValidator numbersValidator = new NumbersValidator();

    @Test
    public void should_be_able_to_return_false_if_less_than_four_numbers() {
        // given
        List<Integer> numbers = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };

        // when
        Boolean result = numbersValidator.validate(numbers);

        // then
        assertThat(result, is(false));
    }

    @Test
    public void should_be_able_to_return_false_if_more_than_four_numbers() {
        // given
        List<Integer> numbers = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };

        // when
        Boolean result = numbersValidator.validate(numbers);

        // then
        assertThat(result, is(false));
    }

    @Test
    public void should_be_able_to_return_false_if_has_same_numbers() {
        // given
        List<Integer> numbers = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(3);
            }
        };

        // when
        Boolean result = numbersValidator.validate(numbers);

        // then
        assertThat(result, is(false));
    }

    @Test
    public void should_be_able_to_return_false_if_has_number_less_than_zero() {
        // given
        List<Integer> numbers = new ArrayList<Integer>() {
            {
                add(-1);
                add(0);
                add(1);
                add(2);
            }
        };

        // when
        Boolean result = numbersValidator.validate(numbers);

        // then
        assertThat(result, is(false));
    }

    @Test
    public void should_be_able_to_return_false_if_has_number_more_than_nine() {
        // given
        List<Integer> numbers = new ArrayList<Integer>() {
            {
                add(10);
                add(1);
                add(2);
                add(3);
            }
        };

        // when
        Boolean result = numbersValidator.validate(numbers);

        // then
        assertThat(result, is(false));
    }

    @Test
    public void should_be_able_to_return_true_if_four_different_numbers_and_all_not_less_than_zero_and_not_more_than_nine() {
        // given
        List<Integer> numbers = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };

        // when
        boolean result = numbersValidator.validate(numbers);

        // then
        assertThat(result, is(true));
    }
}
