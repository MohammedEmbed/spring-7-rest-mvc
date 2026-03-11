package com.momed.spring7restmvc.controllers;

import com.momed.spring7restmvc.model.Beer;
import com.momed.spring7restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    public final BeerService beerService;

    public Beer getBeerById(UUID id){

        log.debug("getBeerById() called in controller. Id: {}", id);
        return beerService.getBeerById(id);
    }
}
