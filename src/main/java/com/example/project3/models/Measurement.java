package com.example.project3.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Min(value = -100, message = "Value should be greater then -100")
    @Max(value = 100, message = "Value should be lesser then 100")
    @NotNull
    @Column(name = "value")
    private Integer value;

    @NotNull
    @Column(name = "raining")
    private Boolean raining;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "id")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(int value, boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
