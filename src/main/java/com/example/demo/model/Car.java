package com.example.demo.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CAR")
@Component
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;

    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    private String currentRentPoint;

    @OneToMany(mappedBy = "number", fetch = FetchType.EAGER)
    private Collection<RentHistory> rentHistoryCollection;

    private boolean isAvailable;

    public String getCurrentRentPoint() {
        return currentRentPoint;
    }

    public Car(){
    }

    public Car(String model, String number, String currentRentPoint) {

        this.model = model;
        this.number = number;
        this.currentRentPoint = currentRentPoint;
    }

    public Car(String model, String number, String currentRentPoint, Collection<RentHistory> rentHistoryCollection, boolean isAvailable) {

        this.model = model;
        this.number = number;
        this.currentRentPoint = currentRentPoint;
        this.rentHistoryCollection = rentHistoryCollection;
        this.isAvailable = isAvailable;
    }

    public void setCurrentRentPoint(String currentRentPoint) {
        this.currentRentPoint = currentRentPoint;
    }

    public Collection<RentHistory> getRentHistoryCollection() {
        return rentHistoryCollection;
    }

    public void setRentHistoryCollection(Collection<RentHistory> rentHistoryCollection) {
        this.rentHistoryCollection = rentHistoryCollection;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Car(String model, String number) {
        this.model = model;
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
