package com.ang.test.offer.service;

import com.ang.test.offer.dto.OfferDTO;
import javassist.NotFoundException;

import java.util.Date;
import java.util.List;

public interface OfferService {

    public List<OfferDTO> findAll(Date activeOn);

    public OfferDTO save(OfferDTO offer);

    public OfferDTO delete(Long id) throws NotFoundException;

}
