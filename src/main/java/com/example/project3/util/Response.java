package com.example.project3.util;

import com.example.project3.dto.MeasurementDTO;

import java.util.List;

public class Response {

    private List<MeasurementDTO> list;

    public Response(List<MeasurementDTO> list) {
        this.list = list;
    }

    public List<MeasurementDTO> getList() {
        return list;
    }

    public void setList(List<MeasurementDTO> list) {
        this.list = list;
    }
}
