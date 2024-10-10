package com.application.withoutesp321.model;

import java.io.Serializable;

public class SensorData implements Serializable {
    private String id;
    private double temperature;
    private double humidity;

    public SensorData(String id, double temperature, double humidity) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id='" + id + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
