package com.jalgoz.springsecurity.game.application.port.in.commands;

import com.jalgoz.springsecurity.game.domain.Comment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class GameCommand {
  private UUID id;
  @NotNull @NotBlank private String name;
  @NotNull @NotBlank private String developer;
  @NotNull @NotBlank private String genre;
  private String designers;
  private String classification;
  @NotNull @NotBlank private String poster;
  @NotNull private int year;
}
