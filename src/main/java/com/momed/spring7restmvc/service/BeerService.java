package com.momed.spring7restmvc.service;

import com.momed.spring7restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID uuid);
}
