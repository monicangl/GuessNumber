package com.github.monicangl.tdd.guessnumber;

public class GameRunner {
    public static void main(String[] args) {
        GamePlayer player = new GamePlayer();

        AnswerGenerator answerGenerator = new AnswerGenerator();
        AnswerValidator answerValidator = new AnswerValidator();
        Answer answer = new Answer(answerValidator);
        GuessNumberGame game = new GuessNumberGame(answerGenerator, answer);

        game.start();
        player.play(game);
        System.out.print(game.getResult());
    }
}
