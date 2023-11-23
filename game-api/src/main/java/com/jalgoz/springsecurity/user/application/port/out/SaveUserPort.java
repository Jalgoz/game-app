package com.jalgoz.springsecurity.user.application.port.out;

import com.jalgoz.springsecurity.user.domain.User;

public interface SaveUserPort {
  User saveUser(User user);
}
