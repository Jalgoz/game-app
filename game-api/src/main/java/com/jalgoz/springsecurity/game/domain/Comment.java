package com.jalgoz.springsecurity.game.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Comment {
  private UUID id;
  private String username;
  private String comment;
  private LocalDateTime timestamp;
}
