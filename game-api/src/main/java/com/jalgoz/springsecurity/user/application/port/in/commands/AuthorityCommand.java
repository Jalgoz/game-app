package com.jalgoz.springsecurity.user.application.port.in.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class AuthorityCommand {
  private UUID id;
  @NotNull @NotBlank private String name;
}
