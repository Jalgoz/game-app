package com.jalgoz.springsecurity.game.application.port.in;

import java.util.UUID;

@FunctionalInterface
public interface RemoveGameUseGame {
  void removeGame(UUID id);
}
