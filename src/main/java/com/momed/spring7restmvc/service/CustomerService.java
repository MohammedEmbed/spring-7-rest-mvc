package com.momed.spring7restmvc.service;

import com.momed.spring7restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> listCustomers();

    Customer getCustomerById(UUID uuid);
}
