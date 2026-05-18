package com.hardware.products.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardware.products.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsProductById(Long id_product);
    boolean existsProductByName(String name);
    Product findProductById_product(Long id_product);
    Optional<Product> findProductByName(String name);
    Optional<Product> findProductById_productAndDeletedAtIsNull(Long id_product);
}
