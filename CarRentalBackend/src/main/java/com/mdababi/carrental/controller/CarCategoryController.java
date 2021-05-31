package com.mdababi.carrental.controller;

import com.mdababi.carrental.exeptionsHandlers.CarCategoryNotEmptyExeption;
import com.mdababi.carrental.model.CarCategory;
import com.mdababi.carrental.service.CarCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/carCategory")
@AllArgsConstructor
public class CarCategoryController {
    CarCategoryService carCategoryService;

    @PostMapping("/add")
    public ResponseEntity<CarCategory> saveCarCategory(@Valid @RequestBody CarCategory carCategory) {
        CarCategory savedCarCategory = carCategoryService.save(carCategory);
        return new ResponseEntity(savedCarCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarCategory> getCarCategoryById(@PathVariable("id") Long id) {
        CarCategory carCategory = carCategoryService.findById(id).orElse(null);
        if (carCategory == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(carCategory, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CarCategory> updateCarCategory(@Valid @RequestBody CarCategory carCategory) {
        CarCategory savedCarCategory = carCategoryService.save(carCategory);
        return new ResponseEntity(savedCarCategory, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarCategoryById(@PathVariable("id") Long id) throws Exception {
        carCategoryService.deleteById(id);
    }

}
