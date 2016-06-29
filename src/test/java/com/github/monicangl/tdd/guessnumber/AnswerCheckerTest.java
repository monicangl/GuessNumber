package com.github.monicangl.tdd.guessnumber;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnswerCheckerTest {
    private AnswerChecker answerChecker;

    public AnswerCheckerTest() {
        answerChecker = new AnswerChecker(new AnswerValidator());
        answerChecker.setAnswer(new Integer[]{1, 2, 3, 4});
    }

    @Test
    public void should_be_able_to_prompt_4A0B_if_four_right_numbers_on_right_position() {
        // given
        Integer[] playerAnswer = new Integer[]{1, 2, 3, 4};

        // when
        String result = answerChecker.check(playerAnswer).getValue();

        // then
        assertThat(result, is("4A0B"));
    }

    @Test
    public void should_be_able_to_prompt_1A0B_if_one_number_right_on_right_position_and_no_number_right_on_wrong_position() {
        // given
        Integer[] playerAnswer = new Integer[]{1, 5, 6, 7};
        // when
        String result = answerChecker.check(playerAnswer).getValue();

        // then
        assertThat(result, is("1A0B"));
    }

    @Test
    public void should_be_able_to_prompt_0A2B_if_zero_right_number_on_right_position_and_two_right_number_on_wrong_position() {
        // given
        Integer[] playerAnswer = new Integer[]{2, 4, 7 ,8};
        // when
        String result = answerChecker.check(playerAnswer).getValue();

        // then
        assertThat(result, is("0A2B"));
    }

    @Test
    public void should_be_able_to_prompt_1A2B_if_one_right_number_on_right_position_and_two_right_number_on_wrong_position() {
        // given
        Integer[] playerAnswer = new Integer[]{0, 3, 2, 4};
        // when
        String result = answerChecker.check(playerAnswer).getValue();

        // then
        assertThat(result, is("1A2B"));
    }

    @Test
    public void should_be_able_to_prompt_0A0B_if_zero_right_number_on_right_position_and_zero_right_number_on_wrong_position() {
        // given
        Integer[] playerAnswer = new Integer[]{5, 6, 7, 8};
        // when
        String result = answerChecker.check(playerAnswer).getValue();

        // then
        assertThat(result, is("0A0B"));
    }

    @Test
    public void should_be_able_to_prompt_0A4B_if_zero_right_number_on_right_position_and_four_right_number_on_wrong_position() {
        // given
        Integer[] playerAnswer = new Integer[]{4, 3, 2, 1};
        // when
        String result = answerChecker.check(playerAnswer).getValue();

        // then
        assertThat(result, is("0A4B"));
    }

    @Test
    public void should_be_able_to_prompt_error_message_if_player_answer_has_same_numbers() throws Exception{
        // given
        Integer[] playerAnswer = new Integer[]{1, 1, 2, 3};
        AnswerValidator validator = new AnswerValidator();
        AnswerChecker answerChecker = new AnswerChecker(validator);

        // when
        String result = answerChecker.check(playerAnswer).getValue();

        // then
        assertThat(result, is("输入不正确，重新输入"));
    }

    @Test
    public void should_be_able_to_prompt_error_message_if_player_answer_not_four_numbers() throws Exception{
        // given
        Integer[] playerAnswer = new Integer[]{1, 2};
        AnswerValidator validator = new AnswerValidator();
        AnswerChecker answerChecker = new AnswerChecker(validator);

        // when
        String result = answerChecker.check(playerAnswer).getValue();

        // then
        assertThat(result, is("输入不正确，重新输入"));
    }
}
