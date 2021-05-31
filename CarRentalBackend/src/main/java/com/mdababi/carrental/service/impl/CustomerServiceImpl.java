package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.exeptionsHandlers.CarCategoryNotEmptyExeption;
import com.mdababi.carrental.exeptionsHandlers.RentalListNotEmptyExeption;
import com.mdababi.carrental.model.Customer;
import com.mdababi.carrental.repositories.CustomerRepository;
import com.mdababi.carrental.repositories.RentalRepository;
import com.mdababi.carrental.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;

    @Override
    public Customer save(Customer customer) {
        customer.getRentalList().forEach(rental -> rentalRepository.save(rental));
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) throws RentalListNotEmptyExeption {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer!=null){
            if(customer.getRentalList().size()>0) throw new RentalListNotEmptyExeption();
            customerRepository.deleteById(id);
        }
    }
}
