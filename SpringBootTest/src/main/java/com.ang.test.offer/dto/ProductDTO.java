package com.ang.test.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    // Prevent XSS
    @NotNull // Not null
    @Size(max=150) // 150 chars
    private String name;

    // No negative
    @Digits(integer=10, fraction=2) // 10 integer positions, 2 decimal positions
    private BigDecimal price;

}
