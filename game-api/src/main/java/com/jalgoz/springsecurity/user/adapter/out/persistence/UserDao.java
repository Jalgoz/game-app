package com.jalgoz.springsecurity.user.adapter.out.persistence;

import com.jalgoz.springsecurity.common.Mapper;
import com.jalgoz.springsecurity.common.PersistenceAdapter;
import com.jalgoz.springsecurity.user.adapter.exception.UserNotFoundException;
import com.jalgoz.springsecurity.user.adapter.out.persistence.model.UserJpaEntity;
import com.jalgoz.springsecurity.user.adapter.out.persistence.repository.SpringDataUserRepository;
import com.jalgoz.springsecurity.user.application.port.out.FindUserPort;
import com.jalgoz.springsecurity.user.application.port.out.SaveUserPort;
import com.jalgoz.springsecurity.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserDao implements SaveUserPort, FindUserPort {
  private final SpringDataUserRepository userRepository;

  @Override
  public User findUser(String username) {
    final Optional<UserJpaEntity> userJpaEntity = userRepository.findByUsername(username);

    if (userJpaEntity.isEmpty()) {
      throw new UserNotFoundException(username);
    }

    return Mapper.convert(userJpaEntity, User.class);
  }

  @Override
  public User saveUser(User user) {
    final UserJpaEntity userJpaEntity = Mapper.convert(user, UserJpaEntity.class);
    return Mapper.convert(userRepository.save(userJpaEntity), User.class);
  }
}
