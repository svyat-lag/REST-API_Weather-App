package com.example.project3.services;

import com.example.project3.models.Sensor;
import com.example.project3.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SensorsService {

    private final SensorsRepository sensorRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    public boolean findByName(Sensor sensor) {
        return sensorRepository.findByName(sensor.getName()).isPresent();
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }
}
