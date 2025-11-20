package com.kaua_dev.order_service.service;

import com.kaua_dev.order_service.domain.order.Order;
import com.kaua_dev.order_service.domain.order.exceptions.OrderNotFoundException;
import com.kaua_dev.order_service.domain.order.exceptions.UserNotFoundException;
import com.kaua_dev.order_service.repositories.OrderRepository;
import feign.product_service.ProductClient;
import feign.product_service.dto.ProductClientDTO;
import feign.user_service.UserClient;
import feign.user_service.dto.UserClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final UserClient userClient; // proxy, comunicaçao com user-service
    private final ProductClient productClient;

    public OrderService(OrderRepository repository, UserClient userClient, ProductClient productClient) {
        this.repository = repository;
        this.userClient = userClient;
        this.productClient = productClient;
    }

    public List<Order> findAll() {return repository.findAll();}
    public Order findById(Long id) {return repository.findById(id).orElseThrow(OrderNotFoundException::new);}

    public Order create(Long userId) {
        Order order = new Order();

        // comunicação com user-service
        UserClientDTO user = userClient.findById(userId);
        if (user == null) throw new UserNotFoundException();

        // comunicação com product-service
        ProductClientDTO product = productClient.findById();

        // EM PROCESSO
    }
}
