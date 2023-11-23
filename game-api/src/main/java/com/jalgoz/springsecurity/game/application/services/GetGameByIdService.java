package com.jalgoz.springsecurity.game.application.services;

import com.jalgoz.springsecurity.common.Mapper;
import com.jalgoz.springsecurity.common.UseCase;
import com.jalgoz.springsecurity.game.adapter.in.web.dto.GameDto;
import com.jalgoz.springsecurity.game.application.port.in.GetGameByIdUseCase;
import com.jalgoz.springsecurity.game.application.port.out.FindGameByIdPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetGameByIdService implements GetGameByIdUseCase {
  private final FindGameByIdPort findGameByIdPort;

  @Override
  public GameDto findGameById(UUID id) {
    return Mapper.convert(findGameByIdPort.getGameById(id), GameDto.class);
  }
}
