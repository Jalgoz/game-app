package com.jalgoz.springsecurity.user.application.services;

import com.jalgoz.springsecurity.common.Mapper;
import com.jalgoz.springsecurity.common.UseCase;
import com.jalgoz.springsecurity.user.application.port.in.RegisterUserUseCase;
import com.jalgoz.springsecurity.user.application.port.in.commands.UserCommand;
import com.jalgoz.springsecurity.user.application.port.out.SaveUserPort;
import com.jalgoz.springsecurity.user.domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.security.Principal;
import java.time.LocalDateTime;

@UseCase
@Validated
@Transactional
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {
  private final SaveUserPort saveUserPort;

  @Override
  public UserCommand registerUser(Principal principal) {
    final User user = User
        .builder()
        .username(principal.getName())
        .createdDate(LocalDateTime.now())
        .build();
    return Mapper.convert(saveUserPort.saveUser(user), UserCommand.class);
  }
}
