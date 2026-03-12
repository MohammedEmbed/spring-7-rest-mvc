package com.momed.spring7restmvc.service;

import com.momed.spring7restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID uuid);
}
