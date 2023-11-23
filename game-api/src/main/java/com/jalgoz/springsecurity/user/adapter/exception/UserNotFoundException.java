package com.jalgoz.springsecurity.user.adapter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("UserExtra of %s not found".formatted(username));
    }
}
