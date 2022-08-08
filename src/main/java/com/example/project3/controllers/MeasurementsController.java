package com.example.project3.controllers;

import com.example.project3.dto.MeasurementDTO;
import com.example.project3.models.Measurement;
import com.example.project3.services.MeasurementsService;
import com.example.project3.util.ErrorResponse;
import com.example.project3.util.ErrorsUtil;
import com.example.project3.util.MeasurementNotCreatedException;
import com.example.project3.util.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    private final MeasurementsService measurementsService;

    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService, ModelMapper modelMapper) {
        this.measurementsService = measurementsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public Response findAll() {
        return new Response(measurementsService.findAll()
                .stream().map(this::convertMeasurementToDto).collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public MeasurementDTO findById(@PathVariable("id") int id) {
        return convertMeasurementToDto(measurementsService.findById(id));
    }

    @GetMapping("/rainyDaysCount")
    public int findRainyDaysCount() {
        return measurementsService.findRainyDaysCount();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new MeasurementNotCreatedException(
                    ErrorsUtil.returnErrorsToClient(bindingResult)
            );

        measurementsService.save(convertDtoToMeasurement(measurementDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(MeasurementNotCreatedException e) {
        ErrorResponse response = new ErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Measurement convertDtoToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertMeasurementToDto(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}
