package com.jalgoz.springsecurity.game.adapter.out.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "games")
@EqualsAndHashCode(of = {"id", "name"})
public class GameJpaEntity {

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
  private String developer;
  private String genre;
  private String designers;
  private String classification;
  private String poster;
  private short year;
  @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE, orphanRemoval = true)
  @JsonIgnore
  private List<CommentJpaEntity> commentList;

}
