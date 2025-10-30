/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backend.model;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class SensorReading {
    
    private String sensorId;
    private double temperature;
    private double humidity;
    private long timestamp;


    public SensorReading() {}


    public SensorReading(String sensorId, double temperature, double humidity, long timestamp) {
        this.sensorId = sensorId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SensorReading{" +
        "sensorId='" + sensorId + '\'' +
        ", temperature=" + temperature +
        ", humidity=" + humidity +
        ", timestamp=" + timestamp +
        '}';
    }
    
}
