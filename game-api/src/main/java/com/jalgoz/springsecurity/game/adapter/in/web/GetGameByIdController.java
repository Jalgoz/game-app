package com.jalgoz.springsecurity.game.adapter.in.web;

import com.jalgoz.springsecurity.common.WebAdapter;
import com.jalgoz.springsecurity.common.utils.Path;
import com.jalgoz.springsecurity.game.adapter.in.web.dto.GameDto;
import com.jalgoz.springsecurity.game.application.port.in.GetGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetGameByIdController {
  private final GetGameByIdUseCase getGameByIdUseCase;

  @GetMapping(Path.GAME_ID)
  public ResponseEntity<GameDto> getGameById(@PathVariable UUID id) {
    return ResponseEntity.ok(getGameByIdUseCase.findGameById(id));
  }
}
