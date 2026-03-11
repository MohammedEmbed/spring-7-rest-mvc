package com.momed.spring7restmvc.service;

import com.momed.spring7restmvc.model.Beer;
import com.momed.spring7restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {

        log.debug("getBeerById() called in service. Id: {}", id);
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Stella")
                .beerStyle(BeerStyle.LAGER)
                .upc("250406")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(12)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
