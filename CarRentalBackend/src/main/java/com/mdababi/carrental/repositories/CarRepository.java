package com.mdababi.carrental.repositories;

import com.mdababi.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
