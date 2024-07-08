package com.spring.security.repository;

import com.spring.security.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {


    List<Customer> findByEmail(String email);
}
