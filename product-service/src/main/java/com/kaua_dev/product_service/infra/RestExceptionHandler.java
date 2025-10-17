package com.kaua_dev.product_service.infra;


import com.kaua_dev.product_service.domain.product.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFound.class)
    private ResponseEntity<RestErrorMessage> productNotFoundHandler(ProductNotFound exception) {
         RestErrorMessage threatedError = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), exception.getMessage());
         return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(threatedError);
    }

}
