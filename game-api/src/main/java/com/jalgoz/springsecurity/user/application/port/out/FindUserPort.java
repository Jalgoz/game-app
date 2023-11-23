package com.jalgoz.springsecurity.user.application.port.out;

import com.jalgoz.springsecurity.user.domain.User;

@FunctionalInterface
public interface FindUserPort {
  User findUser(String username);
}
