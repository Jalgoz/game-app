package com.jalgoz.springsecurity.user.adapter.out.persistence.model;

import com.jalgoz.springsecurity.user.adapter.out.persistence.model.UserJpaEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator",
      parameters = {
          @Parameter(
              name = "uuid_gen_strategy_class",
              value = "org.hibernate.id.uuid.CustomVersionOneStrategy")
      })
  private UUID id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity user;

}
