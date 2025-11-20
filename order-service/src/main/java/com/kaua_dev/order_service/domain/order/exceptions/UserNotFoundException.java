package com.kaua_dev.order_service.domain.order.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() { super("Usuário não encontrado. "); }
}
