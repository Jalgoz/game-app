package com.jalgoz.springsecurity.game.application.port.out;

import java.util.UUID;

@FunctionalInterface
public interface DeleteGamePort {
  void deleteGame(UUID id);
}
