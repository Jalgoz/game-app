package com.jalgoz.springsecurity.game.adapter.in.web;

import com.jalgoz.springsecurity.common.WebAdapter;
import com.jalgoz.springsecurity.common.utils.Path;
import com.jalgoz.springsecurity.game.adapter.in.web.dto.GameDto;
import com.jalgoz.springsecurity.game.application.port.in.GetAllGamesQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetAllGamesController {
  private final GetAllGamesQuery getAllGamesQuery;

  @GetMapping(Path.GAME)
  public ResponseEntity<Iterable<GameDto>> getAllGames() {
    return ResponseEntity.ok(getAllGamesQuery.getAllGames());
  }
}
