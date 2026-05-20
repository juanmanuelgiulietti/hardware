package com.hardware.products.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardware.products.dto.CreateProductRequest;
import com.hardware.products.dto.ProductResponse;
import com.hardware.products.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Product endpoints")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products/{id_product}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id_product) {
        ProductResponse response = productService.getProductById(id_product);
        return ResponseEntity
                .status(Response.SC_OK)
                .body(response);
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<ProductResponse> getProductByNameContainingIgnoreCase(@PathVariable String name) {
        ProductResponse response = productService.getProductByNameContainingIgnoreCase(name);
        return ResponseEntity
                .status(Response.SC_OK)
                .body(response);
    }

    @GetMapping("/products/category/{id_category}")
    public ResponseEntity<ProductResponse> getProductByIdCategory(@PathVariable Long id_category) {
        ProductResponse response = productService.getProductByIdCategory(id_category);
        return ResponseEntity
                .status(Response.SC_OK)
                .body(response);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity
                .status(Response.SC_CREATED)
                .body(response);
    }
    
}
