package com.example.project3.services;

import com.example.project3.models.Measurement;
import com.example.project3.repositories.MeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeasurementsService {
    private final MeasurementsRepository measurementRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Measurement findById(int id) {
        return measurementRepository.findById(id).orElse(null);
    }

    public int findRainyDaysCount() {
        return measurementRepository.findByRaining(true).size();
    }

    @Transactional
    public void save(Measurement measurement) {
        measurementRepository.save(measurement);
    }
}
