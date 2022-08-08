package com.example.project3.dto;

import com.example.project3.models.Sensor;

public class MeasurementDTO {
    private Integer value;

    private Boolean raining;

    private Sensor sensor;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
