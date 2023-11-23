package com.jalgoz.springsecurity.game.domain;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class Game {
  private UUID id;
  private String name;
  private String developer;
  private String genre;
  private String designers;
  private String classification;
  private String poster;
  private short year;
  private List<Comment> commentList;
}
