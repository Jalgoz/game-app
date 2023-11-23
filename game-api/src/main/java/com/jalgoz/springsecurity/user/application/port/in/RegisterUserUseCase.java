package com.jalgoz.springsecurity.user.application.port.in;

import com.jalgoz.springsecurity.user.application.port.in.commands.UserCommand;

import java.security.Principal;

@FunctionalInterface
public interface RegisterUserUseCase {
  UserCommand registerUser(Principal principal);
}
