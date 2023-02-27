package com.jalgoz.springsecurity.user.adapter.out.persistence.repository;

import com.jalgoz.springsecurity.user.adapter.out.persistence.model.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, UUID> {

  Optional<UserJpaEntity> findByUsername(String username);

}
