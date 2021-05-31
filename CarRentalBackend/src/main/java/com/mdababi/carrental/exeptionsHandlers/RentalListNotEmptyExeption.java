package com.mdababi.carrental.exeptionsHandlers;

public class RentalListNotEmptyExeption extends Exception {

    public RentalListNotEmptyExeption() {
        super();
    }

    public RentalListNotEmptyExeption(String message) {
        super(message);
    }
}