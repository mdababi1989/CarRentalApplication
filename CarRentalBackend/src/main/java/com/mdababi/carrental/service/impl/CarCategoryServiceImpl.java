package com.mdababi.carrental.service.impl;

import com.mdababi.carrental.model.CarCategory;
import com.mdababi.carrental.repositories.CarCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CarCategoryServiceImpl extends BaseServiceImpl<CarCategory, CarCategoryRepository > {

    public CarCategoryServiceImpl(CarCategoryRepository repository) {
        super(repository);
    }
}
