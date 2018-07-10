package com.example.demo.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class RentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private String carNumber;

    private String carModel;

    private String startPoint;

    private String endPoint;

    private String renterName;

    private Date startDate;

    @Nullable
    private Date endDate;

    public RentHistory(){

    }

    public RentHistory(String carNumber, String carModel, String startPoint, String endPoint, String renterName, Date startDate) {
        this.carNumber = carNumber;
        this.carModel = carModel;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.renterName = renterName;
        this.startDate = startDate;
    }

    public RentHistory(String carNumber, String carModel, String startPoint, String endPoint, String renterName, Date startDate, Date endDate) {
        this.carNumber = carNumber;
        this.carModel = carModel;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.renterName = renterName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "RentHistory{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", carModel='" + carModel + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", renterName='" + renterName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
