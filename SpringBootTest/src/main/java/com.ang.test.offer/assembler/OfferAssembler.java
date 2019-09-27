package com.ang.test.offer.assembler;

import com.ang.test.offer.domain.Offer;
import com.ang.test.offer.dto.OfferDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OfferAssembler extends ResourceAssembler<OfferDTO, Offer> {

    private ModelMapper modelMapper;
    private ProductAssembler productAssembler;

    public OfferAssembler(ModelMapper modelMapper, ProductAssembler productAssembler) {
        this.modelMapper = modelMapper;
        this.productAssembler = productAssembler;
    }

    @Override
    public OfferDTO toResource(Offer o) {
        OfferDTO offerDTO = modelMapper.map(o, OfferDTO.class);
        offerDTO.setProduct(productAssembler.toResource(o.getProduct()));
        return offerDTO;
    }

    @Override
    public List<OfferDTO> toResourceList(Iterable<Offer> l) {
        List<OfferDTO> offerDTOList = new ArrayList<>();
        l.forEach(o -> offerDTOList.add(toResource(o)));
        return offerDTOList;
    }

    @Override
    public Offer toResourceInverse(OfferDTO o) {
        Offer offer = modelMapper.map(o, Offer.class);
        offer.setProduct(productAssembler.toResourceInverse(o.getProduct()));
        return offer;
    }

    @Override
    public List<Offer> toResourceInverse(Iterable<OfferDTO> l) {
        List<Offer> offerList = new ArrayList<>();
        l.forEach(o -> offerList.add(toResourceInverse(o)));
        return offerList;
    }
}
