package com.example.demo.service;

import com.example.demo.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    public List<Car> getAllCars();

    public
    Optional<Car> getCarById(Long id);

    public void saveOrUpdate(Car car);

    public void deleteCar(Long id);
}
