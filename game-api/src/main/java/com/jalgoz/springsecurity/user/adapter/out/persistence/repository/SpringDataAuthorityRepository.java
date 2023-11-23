package com.jalgoz.springsecurity.user.adapter.out.persistence.repository;

import com.jalgoz.springsecurity.user.adapter.out.persistence.model.AuthorityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataAuthorityRepository extends JpaRepository<AuthorityJpaEntity, UUID> {
}
