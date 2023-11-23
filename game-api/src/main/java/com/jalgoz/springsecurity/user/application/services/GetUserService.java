package com.jalgoz.springsecurity.user.application.services;

import com.jalgoz.springsecurity.common.Mapper;
import com.jalgoz.springsecurity.common.UseCase;
import com.jalgoz.springsecurity.user.adapter.in.web.dto.UserDto;
import com.jalgoz.springsecurity.user.application.port.in.GetUserUseCase;
import com.jalgoz.springsecurity.user.application.port.out.FindUserPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.security.Principal;

@UseCase
@Transactional
@RequiredArgsConstructor
public class GetUserService implements GetUserUseCase {
  private final FindUserPort findUserPort;

  @Override
  public UserDto getUser(Principal principal) {
    return Mapper.convert(findUserPort.findUser(principal.getName()), UserDto.class);
  }
}
