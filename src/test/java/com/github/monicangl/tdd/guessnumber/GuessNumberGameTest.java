package com.github.monicangl.tdd.guessnumber;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {

    private GuessNumberGame guessNumberGame;

    @Before
    public void setUp() throws Exception {
        Integer[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        guessNumberGame = new GuessNumberGame(answerGenerator);
    }

    @Test
    public void should_be_able_to_return_play_result_when_guess_four_different_numbers_from_0_to_9() {
        // when
        assertThat(guessNumberGame.play(1, 5, 6, 7), is("1A0B"));
        assertThat(guessNumberGame.play(2, 4, 7 ,8), is("0A2B"));
        assertThat(guessNumberGame.play(0, 3, 2, 4), is("1A2B"));
        assertThat(guessNumberGame.play(5, 6, 7, 8), is("0A0B"));
        assertThat(guessNumberGame.play(4, 3, 2, 1), is("0A4B"));
        assertThat(guessNumberGame.play(1, 2, 3, 4), is("4A0B"));
    }

    @Test
    public void should_be_able_to_return_error_message() {
        // when
        String result = guessNumberGame.promptError();

        // then
        assertThat(result, is("输入不正确，重新输入"));
    }

    @Test
    public void should_be_able_to_return_play_history() {
        // when
        guessNumberGame.newGame();
        guessNumberGame.play(1, 5, 2, 3);
        guessNumberGame.play(1, 3, 2, 7);
        guessNumberGame.play(1, 5, 9, 8);

        GameHistory guessRecord = guessNumberGame.getHistory();

        // then
        assertThat(guessRecord.getPlayTimes(), is(3));
        assertThat(guessRecord.getPlayData(0), is(new Integer[]{1, 5, 2, 3}));
        assertThat(guessRecord.getPlayData(1), is(new Integer[]{1, 3, 2, 7}));
        assertThat(guessRecord.getPlayData(2), is(new Integer[]{1, 5, 9, 8}));
        assertThat(guessRecord.getPlayResult(0), is("1A2B"));
        assertThat(guessRecord.getPlayResult(1), is("1A2B"));
        assertThat(guessRecord.getPlayResult(2), is("1A0B"));
    }
}
