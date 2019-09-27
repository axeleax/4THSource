package com.ang.test.offer.repository.impl;

import com.ang.test.offer.domain.Offer;
import com.ang.test.offer.domain.Product;
import com.ang.test.offer.repository.OfferRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Repository
@Primary
public class OfferRepositoryImpl implements OfferRepositoryCustom {

    private static final String QUERY_FIND_BY_DATE = "SELECT * FROM offer WHERE active_until = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Offer> findAll(Date activeOn) {
        List<Offer> offerList = new ArrayList<>();
        List<Map<String, Object>> retList = jdbcTemplate.queryForList(QUERY_FIND_BY_DATE);
        for (Map<String, Object> rowMap : retList) {
            Offer offer = new Offer();
            offer.setId((Long) rowMap.get("id"));
            offer.setDiscountPct((BigDecimal) rowMap.get("discount_pct"));
            offer.setActiveFrom((Date) rowMap.get("active_from"));
            offer.setActiveUntil((Date) rowMap.get("active_until"));
            offer.setProduct((Product) rowMap.get("product"));
            offerList.add(offer);
        }
        return offerList;
    }
}

