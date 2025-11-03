package com.kaua_dev.order_service.service;

import com.kaua_dev.order_service.domain.order.Order;
import com.kaua_dev.order_service.domain.order.exceptions.OrderNotFoundException;
import com.kaua_dev.order_service.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {return repository.findAll();}
    public Order findById(Long id) {return repository.findById(id).orElseThrow(OrderNotFoundException::new);}
}
