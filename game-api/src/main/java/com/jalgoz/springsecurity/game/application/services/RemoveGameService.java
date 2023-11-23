package com.jalgoz.springsecurity.game.application.services;

import com.jalgoz.springsecurity.common.UseCase;
import com.jalgoz.springsecurity.game.application.port.in.RemoveGameUseGame;
import com.jalgoz.springsecurity.game.application.port.out.DeleteGamePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RemoveGameService implements RemoveGameUseGame {
  private final DeleteGamePort deleteGamePort;

  @Override
  public void removeGame(UUID id) {
    deleteGamePort.deleteGame(id);
  }
}
