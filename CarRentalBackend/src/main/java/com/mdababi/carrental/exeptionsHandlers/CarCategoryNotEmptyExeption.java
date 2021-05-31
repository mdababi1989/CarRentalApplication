package com.mdababi.carrental.exeptionsHandlers;

public class CarCategoryNotEmptyExeption extends Exception {

    public CarCategoryNotEmptyExeption() {
        super();
    }

    public CarCategoryNotEmptyExeption(String message) {
        super(message);
    }
}