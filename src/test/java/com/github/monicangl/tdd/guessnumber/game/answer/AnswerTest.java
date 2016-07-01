package com.github.monicangl.tdd.guessnumber.game.answer;

import com.github.monicangl.tdd.guessnumber.game.answer.generator.AnswerGenerator;
import com.github.monicangl.tdd.guessnumber.game.answer.validator.AnswerValidator;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerTest {
    private Answer answer;

    public AnswerTest() {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(newArrayList(1, 2, 3, 4));
        answer = new Answer(answerGenerator, new AnswerValidator());
        answer.initialize();
    }

    @Test
    public void should_be_able_to_prompt_4A0B_if_four_right_numbers_on_right_position() {
        // given
        List<Integer> playerAnswer = newArrayList(1, 2, 3, 4);

        // when
        String result = answer.guess(playerAnswer).getMessage();

        // then
        assertThat(result, is("4A0B"));
    }

    @Test
    public void should_be_able_to_prompt_1A0B_if_one_number_right_on_right_position_and_no_number_right_on_wrong_position() {
        // given
        List<Integer> playerAnswer = newArrayList(1, 5, 6, 7);

        // when
        String result = answer.guess(playerAnswer).getMessage();

        // then
        assertThat(result, is("1A0B"));
    }

    @Test
    public void should_be_able_to_prompt_0A2B_if_zero_right_number_on_right_position_and_two_right_number_on_wrong_position() {
        // given
        List<Integer> playerAnswer = newArrayList(2, 4, 7 ,8);

        // when
        String result = answer.guess(playerAnswer).getMessage();

        // then
        assertThat(result, is("0A2B"));
    }

    @Test
    public void should_be_able_to_prompt_1A2B_if_one_right_number_on_right_position_and_two_right_number_on_wrong_position() {
        // given
        List<Integer> playerAnswer = newArrayList(0, 3, 2, 4);

        // when
        String result = answer.guess(playerAnswer).getMessage();

        // then
        assertThat(result, is("1A2B"));
    }

    @Test
    public void should_be_able_to_prompt_0A0B_if_zero_right_number_on_right_position_and_zero_right_number_on_wrong_position() {
        // given
        List<Integer> playerAnswer = newArrayList(5, 6, 7, 8);

        // when
        String result = answer.guess(playerAnswer).getMessage();

        // then
        assertThat(result, is("0A0B"));
    }

    @Test
    public void should_be_able_to_prompt_0A4B_if_zero_right_number_on_right_position_and_four_right_number_on_wrong_position() {
        // given
        List<Integer> playerAnswer = newArrayList(4, 3, 2, 1);

        // when
        String result = answer.guess(playerAnswer).getMessage();

        // then
        assertThat(result, is("0A4B"));
    }

    @Test
    public void should_be_able_to_prompt_error_message_if_player_answer_has_same_numbers() throws Exception{
        // given
        List<Integer> playerAnswer = newArrayList(1, 1, 2, 3);


        // when
        String result = answer.guess(playerAnswer).getMessage();

        // then
        assertThat(result, is("输入不正确，重新输入"));
    }

    @Test
    public void should_be_able_to_prompt_error_message_if_player_answer_not_four_numbers() throws Exception{
        // given
        List<Integer> playerAnswer = newArrayList(1, 2);


        // when
        String result = answer.guess(playerAnswer).getMessage();

        // then
        assertThat(result, is("输入不正确，重新输入"));
    }
}
