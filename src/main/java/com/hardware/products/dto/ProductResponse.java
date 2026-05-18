package com.hardware.products.dto;

import java.math.BigDecimal;
import com.hardware.products.entity.Category;

import com.hardware.products.entity.Brand;

import lombok.Builder;

@Builder
public record ProductResponse(
    Long id_product,
    String name,
    Brand brand,
    Category category,
    BigDecimal price
) {}