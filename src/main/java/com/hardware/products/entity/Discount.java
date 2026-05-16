package com.hardware.products.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Discount entity representing a product discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_discount;

    @Column(nullable = false, unique = true)
    private BigDecimal percentage;

    @Column(nullable = false, unique = true)
    private LocalDateTime startTime;

    @Column(nullable = false, unique = true)
    private LocalDateTime endDate;

    @Column(nullable = false, unique = true)
    private boolean isActive;
}
