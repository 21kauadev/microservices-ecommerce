package com.kaua_dev.product_service.domain.product.exceptions;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String message) {
        super(message);
    }
    public ProductNotFound() { super("Produto não encontrado"); }
}
