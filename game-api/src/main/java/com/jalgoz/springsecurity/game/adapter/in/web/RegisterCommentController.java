package com.jalgoz.springsecurity.game.adapter.in.web;

import com.jalgoz.springsecurity.common.WebAdapter;
import com.jalgoz.springsecurity.common.utils.Path;
import com.jalgoz.springsecurity.game.application.port.in.RegisterCommentUseCase;
import com.jalgoz.springsecurity.game.application.port.in.commands.CommentCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterCommentController {
  private final RegisterCommentUseCase registerCommentUseCase;

  @PostMapping(Path.COMMENTS_ID)
  public ResponseEntity<CommentCommand> registerComment(
      @RequestBody CommentCommand commentCommand,
      @PathVariable UUID id,
      Principal principal) {
    return ResponseEntity.status(HttpStatus.CREATED).body(registerCommentUseCase.registerComment(commentCommand, id, principal));
  }
}
