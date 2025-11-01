package com.kaua_dev.order_service.repositories;

import com.kaua_dev.order_service.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
