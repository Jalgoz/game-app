package com.jalgoz.springsecurity.game.application.port.in;

import com.jalgoz.springsecurity.game.application.port.in.commands.CommentCommand;
import jakarta.validation.Valid;

import java.security.Principal;
import java.util.UUID;

@FunctionalInterface
public interface RegisterCommentUseCase {
  CommentCommand registerComment(@Valid CommentCommand commentCommand, UUID id, Principal principal);
}
