package com.jalgoz.springsecurity.game.adapter.out.persistence.repository;

import com.jalgoz.springsecurity.game.adapter.out.persistence.model.CommentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCommentRepository extends JpaRepository<CommentJpaEntity, UUID> {
}
