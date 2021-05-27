package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Customer;
import com.mdababi.carrental.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, CustomerRepository > {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
