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
        Integer[] numbers = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(numbers);
        AnswerValidator answerValidator = new AnswerValidator();
        Answer answer = new Answer(answerGenerator, answerValidator);
        guessNumberGame = new GuessNumberGame(answer);
        guessNumberGame.start();
    }

    @Test
    public void should_be_able_to_failed_if_not_guess_right_for_six_times() {
        // given

        // when
        guessNumberGame.play(new Integer[]{1, 2, 4, 5});
        guessNumberGame.play(new Integer[]{2, 3, 7, 8});
        guessNumberGame.play(new Integer[]{5, 6, 4, 7});
        guessNumberGame.play(new Integer[]{1, 2});
        guessNumberGame.play(new Integer[]{1, 3, 4, 5});
        guessNumberGame.play(new Integer[]{1, 2, 6, 9});

        // then
        assertThat(guessNumberGame.getResult(), is("六次未猜中,游戏失败"));
    }

    @Test
    public void should_be_able_to_success_if_guess_right_within_six_times() {
        // given

        // when
        guessNumberGame.play(new Integer[]{2, 3, 4, 5});
        guessNumberGame.play(new Integer[]{1, 3, 7, 8});
        guessNumberGame.play(new Integer[]{1, 2, 3, 4});

        // then
        assertThat(guessNumberGame.getResult(), is("全中,胜出"));
    }

    @Test
    public void should_be_able_to_return_play_history() {
        // when
        guessNumberGame.start();
        guessNumberGame.play(new Integer[]{1, 5, 2, 3});
        guessNumberGame.play(new Integer[]{1, 3, 2, 7});
        guessNumberGame.play(new Integer[]{1, 5, 9, 8});

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
