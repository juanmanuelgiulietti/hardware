package com.hardware.products.service;

import com.hardware.products.dto.CreateProductRequest;
import com.hardware.products.dto.ProductResponse;
import com.hardware.products.entity.Product;

public interface ProductService {
    Product saveProduct(Product product);
    ProductResponse getProductById(Long id_product);
    ProductResponse createProduct(CreateProductRequest request);
}
