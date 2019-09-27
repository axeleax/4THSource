package com.ang.test.offer.repository;

import com.ang.test.offer.domain.Offer;

import java.util.Date;
import java.util.List;

public interface OfferRepositoryCustom {

    List<Offer> findAll(Date activeOn);
}
