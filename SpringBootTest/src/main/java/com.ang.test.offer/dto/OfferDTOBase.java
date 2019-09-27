package com.ang.test.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTOBase {

    private BigDecimal discountPct;

    @NotNull // Mandatory
    @DateTimeFormat(pattern = "MM/dd/yyyy") // Output format: MM/dd/yyyy & Input format: MM/dd/yyyy
    private Date activeFrom;

    // Optional
    @DateTimeFormat(pattern = "MM/dd/yyyy") // Output format: MM/dd/yyyy & Input format: MM/dd/yyyy
    private Date activeUntil;

    // Calculated
    private BigDecimal discountedPrice;

    // Calculated
    private BigDecimal saving;

    @NotNull // Product ID is mandatory
    private ProductDTO product;
}
