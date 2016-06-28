package com.github.monicangl.tdd.guessnumber;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {

    private GuessNumberGame guessNumberGame;
    List<Integer> answer;

    @Before
    public void setUp() throws Exception {

        answer = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };

        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        guessNumberGame = new GuessNumberGame(answerGenerator);
    }

    @Test
    public void should_be_able_to_return_play_result_when_guess_four_different_numbers_from_0_to_9() {
        // given
        List<Integer> oneTwoThreeFour = answer;
        List<Integer> oneFiveSixSeven = new ArrayList<Integer>() {
            {
                add(1);
                add(5);
                add(6);
                add(7);
            }
        };

        List<Integer> twoFourSevenEight = new ArrayList<Integer>() {
            {
                add(2);
                add(4);
                add(7);
                add(8);
            }
        };

        List<Integer> zeroThreeTwoFour = new ArrayList<Integer>() {
            {
                add(0);
                add(3);
                add(2);
                add(4);
            }
        };

        List<Integer> fiveSixSevenEight = new ArrayList<Integer>() {
            {
                add(5);
                add(6);
                add(7);
                add(8);
            }
        };

        List<Integer> fourThreeTwoOne = new ArrayList<Integer>() {
            {
                add(4);
                add(3);
                add(2);
                add(1);
            }
        };

        assertThat(guessNumberGame.play(oneFiveSixSeven), is("1A0B"));
        assertThat(guessNumberGame.play(twoFourSevenEight), is("0A2B"));
        assertThat(guessNumberGame.play(zeroThreeTwoFour), is("1A2B"));
        assertThat(guessNumberGame.play(fiveSixSevenEight), is("0A0B"));
        assertThat(guessNumberGame.play(fourThreeTwoOne), is("0A4B"));
        assertThat(guessNumberGame.play(oneTwoThreeFour), is("0A4B"));
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
        // given
        List<Integer> playDataOne = new ArrayList<Integer>() {
            {
                add(1);
                add(5);
                add(2);
                add(3);
            }
        };

        List<Integer> playDataTwo = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(2);
                add(7);
            }
        };

        List<Integer> playDataThree = new ArrayList<Integer>() {
            {
                add(1);
                add(5);
                add(9);
                add(8);
            }
        };

        // when
        guessNumberGame.newGame();
        guessNumberGame.play(playDataOne);
        guessNumberGame.play(playDataTwo);
        guessNumberGame.play(playDataThree);

        GameHistory guessRecord = guessNumberGame.getHistory();

        // then
        assertThat(guessRecord.getPlayTimes(), is(3));
        assertThat(guessRecord.getPlayData(0), is(playDataOne));
        assertThat(guessRecord.getPlayData(1), is(playDataTwo));
        assertThat(guessRecord.getPlayData(2), is(playDataThree));
        assertThat(guessRecord.getPlayResult(0), is("1A2B"));
        assertThat(guessRecord.getPlayResult(1), is("1A2B"));
        assertThat(guessRecord.getPlayResult(2), is("1A0B"));
    }
}
