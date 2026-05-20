package com.hardware.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hardware.products.dto.CreateProductRequest;
import com.hardware.products.dto.ProductResponse;
import com.hardware.products.entity.Product;
import com.hardware.products.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    protected final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        if (productRepository.existsProductById(request.id_product())) {
        throw new IllegalArgumentException("Product ID already in use.");
        }

        if (productRepository.existsProductByName(request.name())) {
            throw new IllegalArgumentException("Product name already in use.");
        }

        Product product = Product.builder()
                .id_product(request.id_product())
                .name(request.name())
                .brand(request.brand())
                .category(request.category())
                .price(request.price())
                .build();

        Product savedProduct = saveProduct(product);

        return ProductResponse.builder()
                .id_product(savedProduct.getId_product())
                .name(savedProduct.getName())
                .brand(savedProduct.getBrand())
                .category(savedProduct.getCategory())
                .price(savedProduct.getPrice())
                .build();
    }

    @Override
    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public ProductResponse getProductById(Long id_product) {
        if (!productRepository.existsProductById(id_product)) {
            throw new IllegalArgumentException("Product not found.");
        }

        Product product = productRepository.findProductById_product(id_product);
        return ProductResponse.builder()
                .id_product(product.getId_product())
                .name(product.getName())
                .brand(product.getBrand())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();
    }

    @Override
    public ProductResponse getProductByNameContainingIgnoreCase(String name) {
        if (!productRepository.existsProductByName(name)) {
            throw new IllegalArgumentException("Product name no exists.");
        }

        Product product = productRepository.findProductByNameContainingIgnoreCase(name);
        return ProductResponse.builder()
                .id_product(product.getId_product())
                .name(product.getName())
                .brand(product.getBrand())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();
    }

    @Override
    public ProductResponse getProductByIdCategory(Long id_category) {
        Product product = productRepository.findProductById_category(id_category);
        if (product == null) {
            throw new IllegalArgumentException("Product category not found.");
        }

        return ProductResponse.builder()
                .id_product(product.getId_product())
                .name(product.getName())
                .brand(product.getBrand())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        if (productRepository.count() == 0) {
            throw new IllegalArgumentException("No products found.");
        }

        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> ProductResponse.builder()
                        .id_product(product.getId_product())
                        .name(product.getName())
                        .brand(product.getBrand())
                        .category(product.getCategory())
                        .price(product.getPrice())
                        .build())
                .toList();
    }
}
