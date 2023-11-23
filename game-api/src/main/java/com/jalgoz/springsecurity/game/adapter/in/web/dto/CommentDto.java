package com.jalgoz.springsecurity.game.adapter.in.web.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class CommentDto {
  private UUID id;
  private String username;
  private String comment;
  private LocalDateTime timestamp;
}
