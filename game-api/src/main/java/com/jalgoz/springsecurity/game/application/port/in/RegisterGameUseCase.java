package com.jalgoz.springsecurity.game.application.port.in;

import com.jalgoz.springsecurity.game.application.port.in.commands.GameCommand;
import jakarta.validation.Valid;

@FunctionalInterface
public interface RegisterGameUseCase {
  GameCommand registerGame(@Valid GameCommand gameCommand);
}
