package com.jalgoz.springsecurity.user.adapter.out.persistence.repository;

import com.jalgoz.springsecurity.user.adapter.out.persistence.model.AuthorityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataAuthorityRepository extends JpaRepository<AuthorityJpaEntity, UUID> {
}
