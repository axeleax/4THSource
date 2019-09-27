package com.ang.test.offer.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OfferDTOIdMandatory extends OfferDTO {

    @Max(1L)// Between 0 and 1
    @Min(0L)
    @NotNull
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
