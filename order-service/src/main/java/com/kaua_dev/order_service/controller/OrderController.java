package com.kaua_dev.order_service.controller;

import com.kaua_dev.order_service.domain.order.Order;
import com.kaua_dev.order_service.infra.ApiResponse;
import com.kaua_dev.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Order>>> findAll() {
        List<Order> orders = service.findAll();
        ApiResponse<List<Order>> response =
                new ApiResponse<List<Order>>(HttpStatus.OK.value(), true, "Returned orders", orders);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> findById(@PathVariable Long id) {
        Order order = service.findById(id);
        ApiResponse<Order> response =
                new ApiResponse<>(HttpStatus.OK.value(), true, "Found order", order);

        return ResponseEntity.ok().body(response);
    }

}
