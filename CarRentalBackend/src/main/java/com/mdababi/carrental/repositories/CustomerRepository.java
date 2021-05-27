package com.mdababi.carrental.repositories;

import com.mdababi.carrental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
