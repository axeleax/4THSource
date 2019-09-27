package com.ang.test.offer.repository;

import com.ang.test.offer.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>, OfferRepositoryCustom {
}
