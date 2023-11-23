package com.jalgoz.springsecurity.user.domain;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class Authority {
  private UUID id;
  private String name;
}
