package com.kaua_dev.product_service.service;

import com.kaua_dev.product_service.domain.product.Product;
import com.kaua_dev.product_service.domain.product.exceptions.ProductNotFound;
import com.kaua_dev.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {return repository.findAll();}
    public Product findById(Long id) {return repository.findById(id).orElseThrow(ProductNotFound::new);}
}
