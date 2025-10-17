package com.kaua_dev.product_service.service;

import com.kaua_dev.product_service.domain.product.Product;
import com.kaua_dev.product_service.domain.product.ProductDTO;
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

    public Product create(ProductDTO data) {
        Product product = new Product();

        product.setName(data.name());
        product.setDescription(data.description());
        product.setPrice(data.price());
        product.setStock(data.stock());

        return repository.save(product);
    }

    public Product update(Long id, ProductDTO data) {
        Product product = repository.findById(id).orElseThrow(ProductNotFound::new);

        if (data.name() != null) product.setName(data.name());
        if (data.description() != null) product.setName(data.description());
        if (data.price() != null) product.setPrice(data.price());
        if (data.stock() != null) product.setStock(data.stock());

        return repository.save(product);
    }

    public void delete(Long id) {
        Product product = repository.findById(id).orElseThrow(ProductNotFound::new);

        repository.delete(product);
    }
}
