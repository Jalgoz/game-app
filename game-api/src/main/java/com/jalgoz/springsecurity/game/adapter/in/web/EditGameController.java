package com.jalgoz.springsecurity.game.adapter.in.web;

import com.jalgoz.springsecurity.common.WebAdapter;
import com.jalgoz.springsecurity.common.utils.Path;
import com.jalgoz.springsecurity.game.application.port.in.EditGameUseCase;
import com.jalgoz.springsecurity.game.application.port.in.commands.GameCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class EditGameController {
  private final EditGameUseCase editGameUseCase;

  @PutMapping(Path.GAME_ID)
  public ResponseEntity<GameCommand> editGame(@RequestBody GameCommand gameCommand, @PathVariable UUID id) {
    return ResponseEntity.status(HttpStatus.OK).body(editGameUseCase.editGame(gameCommand, id));
  }
}
