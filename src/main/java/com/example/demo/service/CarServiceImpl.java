package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final
    CarRepository carRepository;

    @Autowired
    public
    CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public
    List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public
    Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public
    void saveOrUpdate(Car car) {
        carRepository.save(car);
    }

    public
    void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
