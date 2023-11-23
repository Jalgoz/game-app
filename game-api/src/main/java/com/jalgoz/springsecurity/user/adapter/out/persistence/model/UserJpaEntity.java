package com.jalgoz.springsecurity.user.adapter.out.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(of = {"id", "name"})
public class UserJpaEntity {
  @Id
  @UuidGenerator
  private UUID id;
  private String name;
  private String username;
  private String email;
  private String mobileNumber;
  private String role;
  private LocalDateTime createdDate;
  @JsonIgnore
  @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
  private Set<AuthorityJpaEntity> authorities;
}
