package com.jalgoz.springsecurity.game.application.services;

import com.jalgoz.springsecurity.common.Mapper;
import com.jalgoz.springsecurity.common.UseCase;
import com.jalgoz.springsecurity.game.adapter.in.web.dto.GameDto;
import com.jalgoz.springsecurity.game.application.port.in.GetAllGamesQuery;
import com.jalgoz.springsecurity.game.application.port.out.FindAllGamesPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetAllGamesService implements GetAllGamesQuery {
  private final FindAllGamesPort findAllGamesPort;

  @Override
  public List<GameDto> getAllGames() {
    return Mapper.convertAll(findAllGamesPort.findAllGames(), GameDto.class);
  }
}
