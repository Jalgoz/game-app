package com.jalgoz.springsecurity.user.application.port.in;

import com.jalgoz.springsecurity.user.adapter.in.web.dto.UserDto;

import java.security.Principal;

@FunctionalInterface
public interface GetUserUseCase {
  UserDto getUser(Principal principal);
}
