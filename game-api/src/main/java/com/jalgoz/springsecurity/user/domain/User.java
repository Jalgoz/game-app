package com.jalgoz.springsecurity.user.domain;

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
public class User {
  private UUID id;
  private String name;
  private String username;
  private String email;
  private String mobileNumber;
  private String role;
  private LocalDateTime createdDate;
  private Set<Authority> authorities;
}
