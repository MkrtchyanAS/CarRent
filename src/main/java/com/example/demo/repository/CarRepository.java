package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findById(Long id);

    void deleteById(Long id);
}
