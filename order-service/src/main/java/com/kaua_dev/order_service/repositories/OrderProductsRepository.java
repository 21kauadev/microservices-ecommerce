package com.kaua_dev.order_service.repositories;

import com.kaua_dev.order_service.domain.order.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {
}
