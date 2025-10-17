package com.kaua_dev.product_service.controller;


import com.kaua_dev.product_service.domain.product.Product;
import com.kaua_dev.product_service.domain.product.ProductDTO;
import com.kaua_dev.product_service.infra.ApiResponse;
import com.kaua_dev.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> findAll() {
        List<Product> products = service.findAll();
        ApiResponse<List<Product>> response =
                new ApiResponse<List<Product>>(HttpStatus.OK.value(), true, "Returned products", products);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> findById(@PathVariable("id") Long id) {
        Product product = service.findById(id);
        ApiResponse<Product> response =
                new ApiResponse<Product>(HttpStatus.OK.value(), true, "Product found", product);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> create(@RequestBody ProductDTO data) {
        Product product = service.create(data);
        ApiResponse<Product> response =
                new ApiResponse<Product>(HttpStatus.CREATED.value(), true, "Product created", product);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> update(@PathVariable("id") Long id, @RequestBody ProductDTO data) {
        Product product = service.update(id, data);
        ApiResponse<Product> response =
                new ApiResponse<Product>(HttpStatus.OK.value(), true, "Product updated", product);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> delete(@PathVariable("id") Long id) {
        service.delete(id);
        ApiResponse<Product> response =
                new ApiResponse<Product>(HttpStatus.OK.value(), true, "Product deleted", null);


        return ResponseEntity.ok().body(response);
    }

}
