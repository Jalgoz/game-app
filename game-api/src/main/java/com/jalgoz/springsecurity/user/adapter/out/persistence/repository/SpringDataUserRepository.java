package com.jalgoz.springsecurity.user.adapter.out.persistence.repository;

import com.jalgoz.springsecurity.user.adapter.out.persistence.model.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, UUID> {

  Optional<UserJpaEntity> findByUsername(String username);

}
