package com.momed.spring7restmvc.controllers;

import com.momed.spring7restmvc.model.Beer;
import com.momed.spring7restmvc.service.BeerService;
import com.momed.spring7restmvc.service.BeerServiceImpl;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    BeerService beerService;

    BeerServiceImpl beerServiceimpl = new BeerServiceImpl();

    @Test
    void testListBeers() throws Exception {
        given(beerService.listBeers()).willReturn(beerServiceimpl.listBeers());

        mockMvc.perform(get("/api/v1/beer")
                .accept(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$.length()",is(3)));
    }
    @Test
    void getBeerById() throws Exception {
        Beer testBeer = beerServiceimpl.listBeers().getFirst();

        given(beerService.getBeerById(testBeer.getId())).willReturn(testBeer);

        mockMvc.perform(get("/api/v1/beer/" + testBeer.getId())
                .accept(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$.id",is(testBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName",is(testBeer.getBeerName())));
    }

}