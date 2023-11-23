package com.jalgoz.springsecurity.game.adapter.in.web.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class GameDto {
  private UUID id;
  private String name;
  private String developer;
  private String genre;
  private String designers;
  private String classification;
  private String poster;
  private short year;
  private List<CommentDto> commentList;
}
