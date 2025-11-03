package com.kaua_dev.order_service.domain.order.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
    public OrderNotFoundException() {super("Pedido não encontrado."); }
}
