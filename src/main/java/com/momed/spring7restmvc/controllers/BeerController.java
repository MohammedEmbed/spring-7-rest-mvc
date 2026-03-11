package com.momed.spring7restmvc.controllers;

import com.momed.spring7restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class BeerController {
    public final BeerService beerService;
}
