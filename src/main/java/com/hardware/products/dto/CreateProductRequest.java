package com.hardware.products.dto;

import java.math.BigDecimal;

import com.hardware.products.entity.Brand;
import com.hardware.products.entity.Category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Schema(description = "Request body for creating a new product")
public record CreateProductRequest(
    Long id_product,

    @Schema(description = "Nombre del producto", example = "Laptop Gamer")
    @NotBlank(message = "Name is required")
    String name,

    @Schema(description = "Marca del producto", example = "BrandX")
    @NotBlank(message = "Brand is required")
    Brand brand,

    @Schema(description = "Categoria del producto", example = "Laptops")
    @NotBlank(message = "Category is required")
    Category category,

    @Schema(description = "Precio del producto", example = "999.99")
    @NotBlank(message = "Price is required")
    @Positive(message = "Price must be positive and not 0")
    BigDecimal price
) {}