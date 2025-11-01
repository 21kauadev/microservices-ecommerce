package com.kaua_dev.order_service.domain.order;

import jakarta.persistence.*;

@Entity
@Table(name = "order_products")
public class OrderProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id",  nullable = false)
    private Long productId;

    // aqui tem join pois o model de Order é do mesmo serviço.
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Long getId() {return id;}

    public Long getProductId() {return productId;}

    public Order getOrder() {return order;}
}
