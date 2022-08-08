package com.example.project3.dto;

import com.example.project3.models.Sensor;

public class MeasurementDTO {
    private Integer value;

    private Boolean raining;

    private SensorDTO sensor;

    public MeasurementDTO() {
    }

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

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
