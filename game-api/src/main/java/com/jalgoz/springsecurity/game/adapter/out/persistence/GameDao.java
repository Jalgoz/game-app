package com.jalgoz.springsecurity.game.adapter.out.persistence;

import com.jalgoz.springsecurity.common.Mapper;
import com.jalgoz.springsecurity.common.PersistenceAdapter;
import com.jalgoz.springsecurity.game.adapter.out.persistence.model.CommentJpaEntity;
import com.jalgoz.springsecurity.game.adapter.out.persistence.model.GameJpaEntity;
import com.jalgoz.springsecurity.game.adapter.out.persistence.repository.SpringDataCommentRepository;
import com.jalgoz.springsecurity.game.adapter.out.persistence.repository.SpringDataGameRepository;
import com.jalgoz.springsecurity.game.application.port.out.*;
import com.jalgoz.springsecurity.game.domain.Comment;
import com.jalgoz.springsecurity.game.domain.Game;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class GameDao implements
    SaveGamePort,
    SaveCommentPort,
    UpdateGamePort,
    DeleteGamePort,
    FindAllGamesPort ,
    FindGameByIdPort
{
  private final String ERROR_ID = "Game with ID %s not found";

  private final SpringDataGameRepository gameRepository;
  private final SpringDataCommentRepository commentRepository;

  @Override
  public Game saveGame(Game game) {
    final GameJpaEntity gameJpaEntity = Mapper.convert(game, GameJpaEntity.class);
    return Mapper.convert(gameRepository.save(gameJpaEntity), Game.class);
  }

  @Override
  public List<Game> findAllGames() {
    final List<GameJpaEntity> games = gameRepository.findAll();
    return Mapper.convertAll(games, Game.class);
  }

  @Override
  public Game updateGame(Game game, UUID id) {
    final Optional<GameJpaEntity> gameJpaEntity = gameRepository.findById(id);

    if (gameJpaEntity.isEmpty()) {
      throw new EntityNotFoundException(String.format(ERROR_ID, id));
    }

    final GameJpaEntity gameJpaEntityToUpdate = Mapper.convert(game, GameJpaEntity.class);
    final GameJpaEntity gameJpaEntityFromDb = gameJpaEntity.get();

    gameJpaEntityToUpdate.setId(gameJpaEntityFromDb.getId());
    gameJpaEntityToUpdate.setCommentList(gameJpaEntityFromDb.getCommentList());
    gameJpaEntityToUpdate
        .getCommentList()
        .forEach(comment -> {
          comment.setGame(gameJpaEntityToUpdate);
        });

    return Mapper.convert(gameRepository.save(gameJpaEntityToUpdate), Game.class);
  }

  @Override
  public Game getGameById(UUID id) {
    String errorId = "Game with ID %s not found";
    final Optional<GameJpaEntity> gameJpaEntity = gameRepository.findById(id);

    if (gameJpaEntity.isEmpty()) {
      throw new EntityNotFoundException(String.format(errorId, id));
    }

    return Mapper.convert(gameJpaEntity, Game.class);
  }

  @Override
  public Comment saveComment(Comment comment, UUID id) {
    final Optional<GameJpaEntity> gameJpaEntity = gameRepository.findById(id);

    if (gameJpaEntity.isEmpty()) {
      throw new EntityNotFoundException(String.format(ERROR_ID, id));
    }

    final CommentJpaEntity commentJpaEntity = Mapper.convert(comment, CommentJpaEntity.class);
    commentJpaEntity.setGame(gameJpaEntity.get());

    return Mapper.convert(commentRepository.save(commentJpaEntity), Comment.class);
  }

  @Override
  public void deleteGame(UUID id) {
    final Optional<GameJpaEntity> gameJpaEntity = gameRepository.findById(id);

    if (gameJpaEntity.isEmpty()) {
      throw new EntityNotFoundException(String.format(ERROR_ID, id));
    }

    gameRepository.deleteById(id);
  }
}
