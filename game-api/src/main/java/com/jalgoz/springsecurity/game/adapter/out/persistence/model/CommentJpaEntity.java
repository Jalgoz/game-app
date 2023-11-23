package com.jalgoz.springsecurity.game.adapter.out.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
@EqualsAndHashCode(of = {"id"})
public class CommentJpaEntity {
  @Id
  @UuidGenerator
  private UUID id;
  private String username;
  private String comment;
  private LocalDateTime timestamp;
  @ManyToOne
  @JoinColumn(name = "game_id")
  private GameJpaEntity game;
}
