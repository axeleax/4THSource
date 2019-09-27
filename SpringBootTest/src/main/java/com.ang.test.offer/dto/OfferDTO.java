package com.ang.test.offer.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


public class OfferDTO extends OfferDTOBase{

    @Max(1L)// Between 0 and 1
    @Min(0L)
    private Long id;

    public OfferDTO(@Max(1L) @Min(0L) Long id,BigDecimal discountPct, @NotNull Date activeFrom,
                    Date activeUntil, BigDecimal discountedPrice, BigDecimal saving, @NotNull ProductDTO product) {
        super(discountPct, activeFrom, activeUntil, discountedPrice, saving, product);
        this.id = id;
    }

    public OfferDTO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
