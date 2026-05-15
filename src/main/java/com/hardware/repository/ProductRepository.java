package com.hardware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardware.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
