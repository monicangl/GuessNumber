package com.github.monicangl.tdd.guessnumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerAnswerValidatorTest {
    private PlayerAnswerValidator playerAnswerValidator = new PlayerAnswerValidator();

    @Test(expected = GameDataInvalidException.class)
    public void should_be_able_to_raise_exception_if_less_than_four_numbers() throws Exception{
        // when
        playerAnswerValidator.validate(new Integer[]{1, 2, 3});
    }

    @Test(expected = GameDataInvalidException.class)
    public void should_be_able_to_raise_exception_if_more_than_four_numbers() throws Exception{
        // when
        playerAnswerValidator.validate(new Integer[]{1, 2, 3, 4, 5});
    }

    @Test(expected = GameDataInvalidException.class)
    public void should_be_able_to_raise_exception_if_has_same_numbers() throws Exception {
        // when
        playerAnswerValidator.validate(new Integer[]{1, 2, 3,  3});
    }

    @Test(expected = GameDataInvalidException.class)
    public void should_raise_exception_if_has_number_less_than_zero() throws Exception {
        // when
        playerAnswerValidator.validate(new Integer[]{-1, 0, 1, 2});
    }

    @Test(expected = GameDataInvalidException.class)
    public void should_raise_exception_if_has_number_more_than_nine() throws Exception{
        // when
        playerAnswerValidator.validate(new Integer[]{10, 1, 2, 3});
    }

    @Test
    public void should_not_raise_exception_if_four_different_numbers_and_from_zero_to_nine() {
        // when
        playerAnswerValidator.validate(new Integer[]{1, 2, 3, 4});
    }
}