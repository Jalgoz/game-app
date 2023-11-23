package com.jalgoz.springsecurity.game.application.services;

import com.jalgoz.springsecurity.common.Mapper;
import com.jalgoz.springsecurity.common.UseCase;
import com.jalgoz.springsecurity.game.application.port.in.RegisterGameUseCase;
import com.jalgoz.springsecurity.game.application.port.in.commands.GameCommand;
import com.jalgoz.springsecurity.game.application.port.out.SaveGamePort;
import com.jalgoz.springsecurity.game.domain.Game;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

@UseCase
@Validated
@Transactional
@RequiredArgsConstructor
public class RegisterGameService implements RegisterGameUseCase {
  private final SaveGamePort saveGamePort;

  @Override
  public GameCommand registerGame(@Valid GameCommand gameCommand) {
    final Game game = saveGamePort.saveGame(Mapper.convert(gameCommand, Game.class));
    return Mapper.convert(game, GameCommand.class);
  }
}
