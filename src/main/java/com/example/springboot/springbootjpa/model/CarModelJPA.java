package com.example.springboot.springbootjpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cartable")
public class CarModelJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "carmodel")
    String carModel;

    @Column(name = "carmounth")
    Integer carMounth;

    @Column(name = "carenginevolume")
    Integer carEngineVolume;

    @Column(name = "cartypebody")
    String carTypeBody;

    @Column(name = "carengine")
    String carEngine;

    @Column(name = "cartransmission")
    String carTransmission;

    public CarModelJPA() {
    }

    public CarModelJPA(Integer id, String carModel, Integer carMounth, Integer carEngineVolume, String carTypeBody, String carEngine, String carTransmission) {
        this.id = id;
        this.carModel = carModel;
        this.carMounth = carMounth;
        this.carEngineVolume = carEngineVolume;
        this.carTypeBody = carTypeBody;
        this.carEngine = carEngine;
        this.carTransmission = carTransmission;
    }

    public CarModelJPA(String carModel, Integer carMounth, Integer carEngineVolume, String carTypeBody, String carEngine, String carTransmission) {
        this.carModel = carModel;
        this.carMounth = carMounth;
        this.carEngineVolume = carEngineVolume;
        this.carTypeBody = carTypeBody;
        this.carEngine = carEngine;
        this.carTransmission = carTransmission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getCarMounth() {
        return carMounth;
    }

    public void setCarMounth(Integer carMounth) {
        this.carMounth = carMounth;
    }

    public Integer getCarEngineVolume() {
        return carEngineVolume;
    }

    public void setCarEngineVolume(Integer carEngineVolume) {
        this.carEngineVolume = carEngineVolume;
    }

    public String getCarTypeBody() {
        return carTypeBody;
    }

    public void setCarTypeBody(String carTypeBody) {
        this.carTypeBody = carTypeBody;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public String getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    @Override
    public String toString() {
        return "CarModelJPA{" +
                "id=" + id +
                ", carModel='" + carModel + '\'' +
                ", carMounth=" + carMounth +
                ", carEngineVolume=" + carEngineVolume +
                ", carTypeBody='" + carTypeBody + '\'' +
                ", carEngine='" + carEngine + '\'' +
                ", carTransmission='" + carTransmission + '\'' +
                '}';
    }
}
