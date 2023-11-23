package com.jalgoz.springsecurity.user.adapter.in.web;

import com.jalgoz.springsecurity.common.WebAdapter;
import com.jalgoz.springsecurity.common.utils.Path;
import com.jalgoz.springsecurity.user.application.port.in.RegisterUserUseCase;
import com.jalgoz.springsecurity.user.application.port.in.commands.UserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterUserController {
  private final RegisterUserUseCase registerUserUseCase;

  @PostMapping(Path.USER)
  public ResponseEntity<UserCommand> registerUser(Principal principal) {
    return ResponseEntity.status(HttpStatus.CREATED).body(registerUserUseCase.registerUser(principal));
  }
}
