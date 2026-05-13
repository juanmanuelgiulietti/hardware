package com.hardware.entity;

import java.beans.Transient;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Product entity representing a hardware product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false, unique = true)
    private String description;

    @Column(nullable = false, unique = true, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, unique = true)
    private int stock;

    @Column(nullable = false, unique = true)
    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "id_discount", nullable = false, unique = true)
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false, unique = true)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false, unique = true)
    private Category category;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedAt;

    @Transient
    public BigDecimal getPriceWithDiscount() {
        if (discount == null) {
            return price;
        }

        if ((discount.isActive()) && (LocalDateTime.now().isAfter(discount.getStartTime()) && LocalDateTime.now().isBefore(discount.getEndDate()))) {
                BigDecimal percentage = discount.getPercentage();

                BigDecimal discountAmount = price.multiply(percentage)
                        .divide(BigDecimal.valueOf(100));

                return price.subtract(discountAmount);
            }
        return price;
    }
}
