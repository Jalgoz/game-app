package com.jalgoz.springsecurity.game.application.port.in.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class CommentCommand {
  private UUID id;
  private String username;
  @NotNull @NotBlank private String comment;
  private LocalDateTime timestamp;
}
