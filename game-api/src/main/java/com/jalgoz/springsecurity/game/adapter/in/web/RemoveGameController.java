package com.jalgoz.springsecurity.game.adapter.in.web;

import com.jalgoz.springsecurity.common.WebAdapter;
import com.jalgoz.springsecurity.common.utils.Path;
import com.jalgoz.springsecurity.game.application.port.in.RemoveGameUseGame;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RemoveGameController {
  private final RemoveGameUseGame removeGameUseGame;

  @DeleteMapping(Path.GAME_ID)
  public ResponseEntity<HttpStatus> removeGame(@PathVariable UUID id) {
    removeGameUseGame.removeGame(id);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
}
