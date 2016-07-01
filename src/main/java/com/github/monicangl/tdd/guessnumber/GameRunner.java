package com.github.monicangl.tdd.guessnumber;

import com.github.monicangl.tdd.guessnumber.game.GuessNumberGame;
import com.github.monicangl.tdd.guessnumber.game.state.GameStatus;
import com.github.monicangl.tdd.guessnumber.player.GamePlayer;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GameRunner {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GameModule());
        GuessNumberGame game = injector.getInstance(GuessNumberGame.class);
        GamePlayer player = new GamePlayer();

        do {
            game.start();
            //        player.play(game);
            do {
                game.play(player.answer());
            }
            while (!game.isOver());

        } while (game.gameStatus() == GameStatus.FAIL);

    }
}
