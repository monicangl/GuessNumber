package com.github.monicangl.tdd.guessnumber;

import com.github.monicangl.tdd.guessnumber.game.GuessNumberGame;
import com.github.monicangl.tdd.guessnumber.game.answer.Answer;
import com.github.monicangl.tdd.guessnumber.game.answer.generator.AnswerGenerator;
import com.github.monicangl.tdd.guessnumber.player.GamePlayer;
import com.github.monicangl.tdd.guessnumber.game.answer.validator.AnswerValidator;

public class GameRunner {
    public static void main(String[] args) {
        GamePlayer player = new GamePlayer();

        AnswerGenerator answerGenerator = new AnswerGenerator();
        AnswerValidator answerValidator = new AnswerValidator();
        Answer answer = new Answer(answerGenerator, answerValidator);
        GuessNumberGame game = new GuessNumberGame(answer);

        //game.start();
        player.play(game);
        System.out.print(game.getResult());
    }
}
