package com.github.monicangl.tdd.guessnumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameDataValidatorTest {
    private GameDataValidator gameDataValidator = new GameDataValidator();

    @Test(expected = GameDataInvalidException.class)
    public void should_be_able_to_raise_exception_if_less_than_four_numbers() throws Exception{
        // given
        List<Integer> numbers = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };

        // when
        gameDataValidator.validate(numbers);
    }

    @Test(expected = GameDataInvalidException.class)
    public void should_be_able_to_raise_exception_if_more_than_four_numbers() throws Exception{
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
        gameDataValidator.validate(numbers);
    }

    @Test(expected = GameDataInvalidException.class)
    public void should_be_able_to_raise_exception_if_has_same_numbers() throws Exception {
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
        gameDataValidator.validate(numbers);
    }

    @Test(expected = GameDataInvalidException.class)
    public void should_raise_exception_if_has_number_less_than_zero() throws Exception {
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
        gameDataValidator.validate(numbers);
    }

    @Test(expected = GameDataInvalidException.class)
    public void should_raise_exception_if_has_number_more_than_nine() throws Exception{
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
        gameDataValidator.validate(numbers);
    }

    @Test
    public void should_not_raise_exception_if_four_different_numbers_and_from_zero_to_nine() {
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
        gameDataValidator.validate(numbers);
    }
}
