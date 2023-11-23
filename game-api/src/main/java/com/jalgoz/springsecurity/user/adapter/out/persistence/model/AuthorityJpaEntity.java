package com.jalgoz.springsecurity.user.adapter.out.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authorities")
@EqualsAndHashCode(of = {"id", "name"})
public class AuthorityJpaEntity {
  @Id
  @UuidGenerator
  private UUID id;
  private String name;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity user;
}
