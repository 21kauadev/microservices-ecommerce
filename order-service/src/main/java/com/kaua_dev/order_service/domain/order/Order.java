package com.kaua_dev.order_service.domain.order;

import com.kaua_dev.order_service.domain.order.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "total_value", nullable = false)
    private Double totalValue;

    @Column(nullable = false)
    private OrderStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    public Long getId() {return id;}

    public Long getUserId() {return userId;}

    public Integer getQuantity() {return quantity;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public Double getTotalValue() {return totalValue;}
    public void setTotalValue(Double totalValue) {this.totalValue = totalValue;}

    public OrderStatus getStatus() {return status;}
    public void setStatus(OrderStatus status) {this.status = status;}

    public LocalDateTime getCreatedAt() {return createdAt;}

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
