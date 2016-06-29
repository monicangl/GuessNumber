package com.github.monicangl.tdd.guessnumber;

public class GameRunner {
    public static void main(String[] args) {
        GamePlayer player = new GamePlayer();

        AnswerGenerator answerGenerator = new AnswerGenerator();
        AnswerValidator answerValidator = new AnswerValidator();
        Answer answer = new Answer(answerGenerator, answerValidator);
        GuessNumberGame game = new GuessNumberGame(answer);

        game.start();
        player.play(game);
        System.out.print(game.getResult());
    }
}
