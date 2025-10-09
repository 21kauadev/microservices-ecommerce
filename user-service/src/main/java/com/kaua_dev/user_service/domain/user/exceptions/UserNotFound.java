package com.kaua_dev.user_service.domain.user.exceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
    public UserNotFound() {super("Usuário não encontrado.");}
}
