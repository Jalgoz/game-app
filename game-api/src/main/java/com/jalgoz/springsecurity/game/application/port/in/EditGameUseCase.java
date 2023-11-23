package com.jalgoz.springsecurity.game.application.port.in;

import com.jalgoz.springsecurity.game.application.port.in.commands.GameCommand;
import jakarta.validation.Valid;

import java.util.UUID;

@FunctionalInterface
public interface EditGameUseCase {
  GameCommand editGame(@Valid GameCommand gameCommand, UUID id);
}
