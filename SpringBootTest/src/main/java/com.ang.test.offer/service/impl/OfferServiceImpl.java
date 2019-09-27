package com.ang.test.offer.service.impl;

import com.ang.test.offer.assembler.OfferAssembler;
import com.ang.test.offer.domain.Offer;
import com.ang.test.offer.domain.Product;
import com.ang.test.offer.dto.OfferDTO;
import com.ang.test.offer.dto.ProductDTO;
import com.ang.test.offer.repository.OfferRepository;
import com.ang.test.offer.service.OfferService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    private OfferAssembler offerAssembler;

    public OfferServiceImpl(OfferAssembler offerAssembler) {
        this.offerAssembler = offerAssembler;
    }

    @Override
    public List<OfferDTO> findAll(Date activeOn) {
        List<Offer> offers = null;

        Date findDate = (activeOn == null) ? new Date() : activeOn;
        offers = offerRepository.findAll(findDate);
        if (offers.isEmpty())
            return new ArrayList<>();
        return offers.stream().map(offer -> new OfferDTO(offer.getId()
                , offer.getDiscountPct(), offer.getActiveFrom(), offer.getActiveUntil()
                , offer.getProduct().getPrice().multiply(new BigDecimal("1.00").subtract(offer.getDiscountPct()))
                , offer.getProduct().getPrice().multiply(offer.getDiscountPct())
                , new ProductDTO(
                offer.getProduct().getId(),
                offer.getProduct().getName(),
                offer.getProduct().getPrice()
        ))).collect(Collectors.toList());
    }

    @Override
    public OfferDTO save(OfferDTO offerDTO) {
        Offer offer = offerAssembler.toResourceInverse(offerDTO);
        Offer saved = offerRepository.save(offer);
        return new OfferDTO(saved.getId()
                , saved.getDiscountPct(), saved.getActiveFrom(), saved.getActiveUntil()
                , saved.getProduct().getPrice().multiply(new BigDecimal("1.00").subtract(saved.getDiscountPct()))
                , saved.getProduct().getPrice().multiply(saved.getDiscountPct())
                , new ProductDTO(
                saved.getProduct().getId(),
                saved.getProduct().getName(),
                saved.getProduct().getPrice()
        ));
    }

    @Override
    public OfferDTO delete(Long id) throws NotFoundException {
        Optional<Offer> optional = offerRepository.findById(id);
        if(optional.isPresent()){
            offerRepository.delete(optional.get());
           return offerAssembler.toResource(optional.get());
        }else{
            throw new NotFoundException("Offer not found");
        }
    }
}
