package com.jalgoz.springsecurity.user.adapter.in.web.dto;

import com.jalgoz.springsecurity.user.adapter.out.persistence.model.AuthorityJpaEntity;
import com.jalgoz.springsecurity.user.domain.Authority;
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
public class UserDto {
  private UUID id;
  private String name;
  private String username;
  private String email;
  private String mobileNumber;
  private String role;
  private LocalDateTime createdDate;
  private Set<Authority> authorities;
}
