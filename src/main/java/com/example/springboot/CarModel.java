package com.example.springboot;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CarModel {

    @Min(1)
    Integer id;

    @NotNull
    String carModel;

    @NotNull
    @Min(1900)
    @Max(2024)
    Integer carMonth;

    @NotNull
    @Min(1900)
    @Max(2024)
    Integer carEngineVolume;

    @NotNull
    String carTypeBody;

    @NotNull
    String carEngine;

    @NotNull
    String carTransmission;

    public CarModel() {
    }

    public CarModel(Integer id, String carModel, Integer carMonth, Integer carEngineVolume, String carTypeBody, String carEngine, String carTransmission) {
        this.id = id;
        this.carModel = carModel;
        this.carMonth = carMonth;
        this.carEngineVolume = carEngineVolume;
        this.carTypeBody = carTypeBody;
        this.carEngine = carEngine;
        this.carTransmission = carTransmission;

    }

    public CarModel(String carModel, Integer carMonth, Integer carEngineVolume, String carTypeBody, String carEngine, String carTransmission) {
        this.carModel = carModel;
        this.carMonth = carMonth;
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

    public Integer getCarMonth() {
        return carMonth;
    }

    public void setCarMonth(Integer carMonth) {
        this.carMonth = carMonth;
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
        return "CarModel{" +
                "id=" + id +
                ", carModel='" + carModel + '\'' +
                ", carMonth=" + carMonth +
                ", carEngineVolume=" + carEngineVolume +
                ", carTypeBody='" + carTypeBody + '\'' +
                ", carEngine='" + carEngine + '\'' +
                ", carTransmission='" + carTransmission + '\'' +
                '}';
    }
}
