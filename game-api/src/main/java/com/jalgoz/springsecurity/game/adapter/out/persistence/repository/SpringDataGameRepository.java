package com.jalgoz.springsecurity.game.adapter.out.persistence.repository;

import com.jalgoz.springsecurity.game.adapter.out.persistence.model.GameJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataGameRepository extends JpaRepository<GameJpaEntity, UUID> {
}
