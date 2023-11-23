package com.jalgoz.springsecurity.game.application.services;

import com.jalgoz.springsecurity.common.Mapper;
import com.jalgoz.springsecurity.common.UseCase;
import com.jalgoz.springsecurity.game.application.port.in.RegisterCommentUseCase;
import com.jalgoz.springsecurity.game.application.port.in.commands.CommentCommand;
import com.jalgoz.springsecurity.game.application.port.out.SaveCommentPort;
import com.jalgoz.springsecurity.game.domain.Comment;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.UUID;

@UseCase
@Validated
@Transactional
@RequiredArgsConstructor
public class RegisterCommentService implements RegisterCommentUseCase {
  private final SaveCommentPort saveCommentPort;

  @Override
  public CommentCommand registerComment(CommentCommand commentCommand, UUID id, Principal principal) {
    commentCommand.setUsername(principal.getName());
    commentCommand.setTimestamp(LocalDateTime.now());
    Comment comment = saveCommentPort.saveComment(Mapper.convert(commentCommand, Comment.class), id);
    return Mapper.convert(comment, CommentCommand.class);
  }
}
