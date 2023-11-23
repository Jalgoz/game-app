package com.jalgoz.springsecurity.game.application.port.out;

import com.jalgoz.springsecurity.game.domain.Comment;

import java.util.UUID;

@FunctionalInterface
public interface SaveCommentPort {
  Comment saveComment(Comment comment, UUID id);
}
