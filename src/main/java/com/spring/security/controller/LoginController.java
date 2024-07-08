package com.spring.security.controller;

import com.spring.security.model.Customer;
import com.spring.security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        if(isNull(customer)) {
           return new ResponseEntity<>("Customer object is empty",HttpStatus.BAD_REQUEST);

        }
        final Customer savedCustomer;
        try{
            savedCustomer  = customerRepository.save(customer);
        } catch (Exception e) {
            return new ResponseEntity<>("Customer didn't got saved",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (savedCustomer.getId() > 0) {
            return new ResponseEntity<>("Customer object saved successfully",HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save customer",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
