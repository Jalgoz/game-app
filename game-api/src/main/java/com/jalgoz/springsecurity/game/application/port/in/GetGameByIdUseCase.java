package com.jalgoz.springsecurity.game.application.port.in;

import com.jalgoz.springsecurity.game.adapter.in.web.dto.GameDto;

import java.util.UUID;

@FunctionalInterface
public interface GetGameByIdUseCase {
  GameDto findGameById(UUID id);
}
