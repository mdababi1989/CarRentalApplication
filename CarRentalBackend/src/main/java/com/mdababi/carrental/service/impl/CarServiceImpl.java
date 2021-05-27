package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Car;
import com.mdababi.carrental.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends BaseServiceImpl<Car, CarRepository> {

    public CarServiceImpl(CarRepository repository) {
        super(repository);
    }
}
