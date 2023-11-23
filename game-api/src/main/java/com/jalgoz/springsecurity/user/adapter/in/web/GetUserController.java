package com.jalgoz.springsecurity.user.adapter.in.web;

import com.jalgoz.springsecurity.common.WebAdapter;
import com.jalgoz.springsecurity.common.utils.Path;
import com.jalgoz.springsecurity.user.adapter.in.web.dto.UserDto;
import com.jalgoz.springsecurity.user.application.port.in.GetUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetUserController {
  private final GetUserUseCase getUserUseCase;

  @GetMapping(Path.USER)
  public ResponseEntity<UserDto> getAllCustomers(Principal principal) {
    return ResponseEntity.ok(getUserUseCase.getUser(principal));
  }
}
