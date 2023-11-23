package com.jalgoz.springsecurity.game.application.services;

import com.jalgoz.springsecurity.common.Mapper;
import com.jalgoz.springsecurity.common.UseCase;
import com.jalgoz.springsecurity.game.application.port.in.EditGameUseCase;
import com.jalgoz.springsecurity.game.application.port.in.commands.GameCommand;
import com.jalgoz.springsecurity.game.application.port.out.UpdateGamePort;
import com.jalgoz.springsecurity.game.domain.Game;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@UseCase
@Validated
@Transactional
@RequiredArgsConstructor
public class EditGameService implements EditGameUseCase {
  private final UpdateGamePort updateGamePort;

  @Override
  public GameCommand editGame(GameCommand gameCommand, UUID id) {
    Game game = updateGamePort.updateGame(Mapper.convert(gameCommand, Game.class), id);
    return Mapper.convert(game, GameCommand.class);
  }
}
