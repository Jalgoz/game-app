package com.jalgoz.springsecurity.game.application.port.out;

import com.jalgoz.springsecurity.game.domain.Game;

@FunctionalInterface
public interface SaveGamePort {
  Game saveGame(Game game);
}
