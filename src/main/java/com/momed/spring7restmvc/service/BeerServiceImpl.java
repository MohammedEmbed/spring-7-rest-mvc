package com.momed.spring7restmvc.service;

import com.momed.spring7restmvc.model.Beer;
import com.momed.spring7restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.fromString("3fecc297-8d01-4c76-a6b3-6a0b829998cf"))
                .version(1)
                .beerName("Stella")
                .beerStyle(BeerStyle.LAGER)
                .upc("250406")
                .price(new BigDecimal("2.99"))
                .quantityOnHand(12)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Jupiler")
                .beerStyle(BeerStyle.LAGER)
                .upc("123456")
                .price(new BigDecimal("0.70"))
                .quantityOnHand(0)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Guinness")
                .beerStyle(BeerStyle.STOUT)
                .upc("635702")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(43)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("getBeerById() called in service. Id: {}", id);
        return beerMap.get(id);
    }
}
