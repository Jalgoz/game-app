package com.jalgoz.springsecurity.game.application.port.out;

import com.jalgoz.springsecurity.game.domain.Game;

import java.util.UUID;

@FunctionalInterface
public interface FindGameByIdPort {
  Game getGameById(UUID id);
}
