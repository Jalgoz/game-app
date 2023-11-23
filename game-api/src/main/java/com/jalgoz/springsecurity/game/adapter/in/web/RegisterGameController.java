package com.jalgoz.springsecurity.game.adapter.in.web;

import com.jalgoz.springsecurity.common.WebAdapter;
import com.jalgoz.springsecurity.common.utils.Path;
import com.jalgoz.springsecurity.game.application.port.in.RegisterGameUseCase;
import com.jalgoz.springsecurity.game.application.port.in.commands.GameCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterGameController {
  private final RegisterGameUseCase registerGameUseCase;

  @PostMapping(Path.GAME)
  public ResponseEntity<GameCommand> registerGame(@RequestBody GameCommand gameCommand) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(registerGameUseCase.registerGame(gameCommand));
  }
}
