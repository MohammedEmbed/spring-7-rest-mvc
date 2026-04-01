package com.momed.spring7restmvc.controllers;

import com.momed.spring7restmvc.model.Customer;
import com.momed.spring7restmvc.service.CustomerService;
import com.momed.spring7restmvc.service.CustomerServiceImpl;
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


@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CustomerService customerService;

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

    @Test
    void ListCustomers() throws Exception {
        given(customerService.listCustomers()).willReturn(customerServiceImpl.listCustomers());

        mockMvc.perform(get("/api/v1/customer")
                        .accept(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$.length()",is(4)));
    }
    @Test
    void getCustomerById() throws Exception {
        Customer testCustomer = customerServiceImpl.listCustomers().getFirst();
        given(customerService.getCustomerById(testCustomer.getId())).willReturn(testCustomer);

        mockMvc.perform(get("/api/v1/customer/"+testCustomer.getId())
                .accept(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$.id",is(testCustomer.getId().toString())))
                .andExpect(jsonPath("$.customerName",is(testCustomer.getCustomerName())));

    }
}