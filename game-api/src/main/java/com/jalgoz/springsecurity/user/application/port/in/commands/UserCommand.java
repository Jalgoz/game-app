package com.jalgoz.springsecurity.user.application.port.in.commands;

import com.jalgoz.springsecurity.user.domain.Authority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class UserCommand {
  private UUID id;
  private String name;
  @NotNull @NotBlank private String username;
  private String email;
  private String mobileNumber;
  private String role;
  private LocalDateTime createdDate;
  private Set<AuthorityCommand> authorities;
}
