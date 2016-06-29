package com.github.monicangl.tdd.guessnumber;

public class GameRunner {
    public static void main(String[] args) {
        GamePlayer player = new GamePlayer();

        AnswerGenerator answerGenerator = new AnswerGenerator();
        PlayerAnswerValidator answerValidator = new PlayerAnswerValidator();
        AnswerChecker answerChecker = new AnswerChecker(answerValidator);
        GuessNumberGame game = new GuessNumberGame(answerGenerator, answerChecker);

        game.start();
        player.play(game);
        System.out.print(game.getResult());
    }
}
