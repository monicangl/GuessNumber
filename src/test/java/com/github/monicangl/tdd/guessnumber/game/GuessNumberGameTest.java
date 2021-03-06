package com.github.monicangl.tdd.guessnumber.game;

import com.github.monicangl.tdd.guessnumber.game.answer.Answer;
import com.github.monicangl.tdd.guessnumber.game.answer.generator.AnswerGenerator;
import com.github.monicangl.tdd.guessnumber.game.answer.validator.AnswerValidator;
import com.github.monicangl.tdd.guessnumber.game.state.GameStatus;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {
    private GuessNumberGame guessNumberGame;

    @Before
    public void setUp() throws Exception {
        AnswerGenerator generator = mock(AnswerGenerator.class);
        when(generator.generate()).thenReturn(newArrayList(1, 2, 3, 4));
        AnswerValidator validator = new AnswerValidator();
        Answer answer = new Answer(generator, validator);
        guessNumberGame = new GuessNumberGame(answer);
        guessNumberGame.start();
    }

    @Test
    public void should_be_able_to_failed_if_not_guess_right_for_six_times() {
        // given

        // when
        guessNumberGame.play(newArrayList(1, 2, 4, 5));
        guessNumberGame.play(newArrayList(2, 3, 7, 8));
        guessNumberGame.play(newArrayList(5, 6, 4, 7));
        guessNumberGame.play(newArrayList(1, 2));
        guessNumberGame.play(newArrayList(1, 3, 4, 5));
        guessNumberGame.play(newArrayList(1, 2, 6, 9));
        // then
        assertThat(guessNumberGame.gameStatus(), is(GameStatus.FAIL));
    }

    @Test
    public void should_be_able_to_success_if_guess_right_within_six_times() {
        // given

        // when
        guessNumberGame.play(newArrayList(2, 3, 4, 5));
        guessNumberGame.play(newArrayList(1, 3, 7, 8));
        guessNumberGame.play(newArrayList(1, 2, 3, 4));

        // then
        assertThat(guessNumberGame.gameStatus(), is(GameStatus.SUCCESS));
    }

    @Test
    public void should_be_able_to_return_play_history() {
        // when
        guessNumberGame.start();
        guessNumberGame.play(newArrayList(1, 5, 2, 3));
        guessNumberGame.play(newArrayList(1, 3, 2, 7));
        guessNumberGame.play(newArrayList(1, 5, 9, 8));

        // then
        assertThat(guessNumberGame.playTimes(), is(3));
        assertThat(guessNumberGame.getRecord(1).getAnswer(), is(newArrayList(1, 3, 2, 7)));
        assertThat(guessNumberGame.getRecord(2).getAnswer(), is(newArrayList(1, 5, 9, 8)));
        assertThat(guessNumberGame.getRecord(0).getResult(), is("1A2B"));
        assertThat(guessNumberGame.getRecord(1).getResult(), is("1A2B"));
        assertThat(guessNumberGame.getRecord(2).getResult(), is("1A0B"));

//        assertThat(guessNumberGame.getRecord(0), is(new GameRecord(newArrayList(1, 5, 2, 3), "1A2B")));
//        assertThat(guessNumberGame.getRecord(1), is(new GameRecord(newArrayList(1, 3, 2, 7), "1A2B")));
//        assertThat(guessNumberGame.getRecord(2), is(new GameRecord(newArrayList(1, 5, 9, 8), "1A0B")));
    }
}
