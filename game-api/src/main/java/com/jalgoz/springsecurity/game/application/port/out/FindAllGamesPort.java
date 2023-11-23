package com.jalgoz.springsecurity.game.application.port.out;

import com.jalgoz.springsecurity.game.domain.Game;

import java.util.List;

public interface FindAllGamesPort {
  List<Game> findAllGames();
}
