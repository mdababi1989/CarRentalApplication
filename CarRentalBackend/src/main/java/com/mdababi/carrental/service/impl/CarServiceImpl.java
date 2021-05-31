package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.Car;
import com.mdababi.carrental.repositories.CarCategoryRepository;
import com.mdababi.carrental.repositories.CarRepository;
import com.mdababi.carrental.service.CarCategoryService;
import com.mdababi.carrental.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarCategoryRepository carCategoryRepository;


    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

}
