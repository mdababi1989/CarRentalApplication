package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.exeptionsHandlers.CarCategoryNotEmptyExeption;
import com.mdababi.carrental.model.CarCategory;
import com.mdababi.carrental.repositories.CarCategoryRepository;
import com.mdababi.carrental.repositories.CarRepository;
import com.mdababi.carrental.service.CarCategoryService;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarCategoryServiceImpl implements CarCategoryService {

    private final CarRepository carRepository;
    private final CarCategoryRepository carCategoryRepository;

    @Override
    public CarCategory save(CarCategory carCategory) {
        carCategory.getCarsList().forEach(carRepository::save);
        return carCategoryRepository.save(carCategory);
    }

    @Override
    public List<CarCategory> findAll() {
        return carCategoryRepository.findAll();
    }

    @Override
    public Optional<CarCategory> findById(Long id) {
        return carCategoryRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) throws CarCategoryNotEmptyExeption {
        CarCategory category = carCategoryRepository.findById(id).orElse(null);
        if (category != null) {
            if (category.getCarsList().size() > 0)
                throw new CarCategoryNotEmptyExeption();
            else carCategoryRepository.deleteById(id);
        }
    }
}
