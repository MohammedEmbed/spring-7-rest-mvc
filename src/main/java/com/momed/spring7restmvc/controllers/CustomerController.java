package com.momed.spring7restmvc.controllers;

import com.momed.spring7restmvc.model.Customer;
import com.momed.spring7restmvc.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PatchMapping("{customerid}")
    public ResponseEntity patchById(@PathVariable("customerid")UUID customerId,@RequestBody Customer customer){
        customerService.patchById(customerId,customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("{customerid}")
    public ResponseEntity deleteById(@PathVariable("customerid")UUID customerId){
        customerService.deleteById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerid}")
    public ResponseEntity updateById(@PathVariable("customerid")UUID customerId, @RequestBody Customer customer) {

        customerService.updateById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer){

        Customer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location","/api/v1/customer/"+savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers(){
        return customerService.listCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable UUID customerId){
        return customerService.getCustomerById(customerId);
    }

}
