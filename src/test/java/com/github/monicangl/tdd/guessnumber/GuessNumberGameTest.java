package com.github.monicangl.tdd.guessnumber;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GuessNumberGameTest {

    private GuessNumberGame guessNumberGame = new GuessNumberGame();
    private List<Integer> rightNumbers;

    @Before
    public void setUp() throws Exception {

        rightNumbers = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };
        guessNumberGame.setNumbers(rightNumbers);
    }

    @Test
    public void should_be_able_to_return_input_error_message_if_input_invalid_numbers() {
        // given
        List<Integer> numbers = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
            }
        };

        // when
        String result = guessNumberGame.guess(numbers);

        // then
        assertThat(result, is("输入不正确，重新输入"));
    }

    @Test
    public void should_be_able_to_return_4A0B_if_guess_right() {
        // when
        String result = guessNumberGame.guess(rightNumbers);

        // then
        assertThat(result, is("4A0B"));
    }

    @Test
    public void should_be_able_to_return_1A2B_if_one_number_is_match_and_on_right_position_and_two_numbers_are_right_but_on_wrong_position() {
        // given
        List<Integer> guessNumbers = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(2);
                add(5);
            }
        };

        // when
        String result = guessNumberGame.guess(guessNumbers);

        // then
        assertThat(result, is("1A2B"));
    }

    @Test
    public void should_be_able_to_return_0A3B_if_no_number_is_match_and_on_right_position_and_three_numbers_are_right_but_on_wrong_position() {
        // given
        List<Integer> guessNumbers = new ArrayList<Integer>() {
            {
                add(0);
                add(1);
                add(2);
                add(3);
            }
        };

        // when
        String result = guessNumberGame.guess(guessNumbers);

        // then
        assertThat(result, is("0A3B"));
    }

    @Test
    public void should_be_able_to_return_guess_numbers_and_guess_result() {
        // given
        List<Integer> guessNumbers = new ArrayList<Integer>() {
            {
                add(1);
                add(5);
                add(2);
                add(3);
            }
        };

        // when
        guessNumberGame.guess(guessNumbers);
        List<String> guessRecord = guessNumberGame.guessRecord();

        // then
        assertThat(guessRecord.get(0), is("1 5 2 3 1A2B"));
    }

    @Test
    public void should_be_able_to_return_guess_numbers_and_guess_result_2() {
        // given
        List<Integer> firstGuessNumbers = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(2);
                add(7);
            }
        };

        List<Integer> secondGuessNumbers = new ArrayList<Integer>() {
            {
                add(1);
                add(5);
                add(9);
                add(8);
            }
        };

        List<Integer> thirdGuessNumbers = new ArrayList<Integer>() {
            {
                add(3);
                add(5);
            }
        };

        // when
        guessNumberGame.guess(firstGuessNumbers);
        guessNumberGame.guess(secondGuessNumbers);
        guessNumberGame.guess(thirdGuessNumbers);
        List<String> guessRecord = guessNumberGame.guessRecord();

        // then
        assertThat(guessRecord.get(0), is("1 3 2 7 1A2B"));
        assertThat(guessRecord.get(1), is("1 5 9 8 1A0B"));
        assertThat(guessRecord.get(2), is("3 5 输入不正确，重新输入"));
    }
}
