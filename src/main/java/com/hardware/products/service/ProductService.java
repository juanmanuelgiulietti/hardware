package com.hardware.products.service;

import java.util.List;

import com.hardware.products.dto.CreateProductRequest;
import com.hardware.products.dto.ProductResponse;
import com.hardware.products.entity.Product;

public interface ProductService {
    Product saveProduct(Product product);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long id_product);
    ProductResponse getProductByNameContainingIgnoreCase(String name);
    ProductResponse getProductByIdCategory(Long id_category);
    ProductResponse createProduct(CreateProductRequest request);
}
