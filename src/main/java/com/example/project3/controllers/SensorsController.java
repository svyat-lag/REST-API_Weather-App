package com.example.project3.controllers;

import com.example.project3.dto.SensorDTO;
import com.example.project3.models.Sensor;
import com.example.project3.services.SensorsService;
import com.example.project3.util.ErrorResponse;
import com.example.project3.util.ErrorsUtil;
import com.example.project3.util.SensorNotCreatedException;
import com.example.project3.util.SensorValidator;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorsService sensorService;
    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;

    public SensorsController(SensorsService sensorService, ModelMapper modelMapper, SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
    }

    @GetMapping
    public List<Sensor> findAll() {
        return sensorService.findAll();
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                             BindingResult bindingResult) {
        Sensor sensorToRegistrate = convertDtoToSensor(sensorDTO);
        sensorValidator.validate(sensorToRegistrate, bindingResult);
        if (bindingResult.hasErrors())
            throw new SensorNotCreatedException(
                    ErrorsUtil.returnErrorsToClient(bindingResult)
            );

        sensorService.save(sensorToRegistrate);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(SensorNotCreatedException e) {
        ErrorResponse response = new ErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Sensor convertDtoToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
