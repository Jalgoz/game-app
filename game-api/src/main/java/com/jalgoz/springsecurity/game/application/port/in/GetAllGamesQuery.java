package com.jalgoz.springsecurity.game.application.port.in;

import com.jalgoz.springsecurity.game.adapter.in.web.dto.GameDto;

import java.util.List;

@FunctionalInterface
public interface GetAllGamesQuery {
  List<GameDto> getAllGames();
}
