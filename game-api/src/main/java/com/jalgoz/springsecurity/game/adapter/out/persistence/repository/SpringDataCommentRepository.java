package com.jalgoz.springsecurity.game.adapter.out.persistence.repository;

import com.jalgoz.springsecurity.game.adapter.out.persistence.model.CommentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataCommentRepository extends JpaRepository<CommentJpaEntity, UUID> {
}
