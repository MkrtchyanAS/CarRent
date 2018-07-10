package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class RentPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    public RentPoint(String address) {

        this.address = address;
    }

    @OneToMany(mappedBy = "number", fetch = FetchType.EAGER)
    private Collection<Car> carCollection;

    public RentPoint(){

    }

    public RentPoint(String address, Collection<Car> carCollection) {
        this.address = address;
        this.carCollection = carCollection;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Collection<Car> getCarCollection() {
        return carCollection;
    }

    public void setCarCollection(Collection<Car> carCollection) {
        this.carCollection = carCollection;
    }

    public void setAddress(String address) {

        this.address = address;
    }

}
