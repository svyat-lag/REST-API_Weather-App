package com.example.project3.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorsUtil {
    public static String returnErrorsToClient(BindingResult bindingResult) {
        StringBuilder errorsMsg = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        errors.forEach(error ->
                errorsMsg.append(error.getField())
                         .append(" - ")
                         .append(error.getDefaultMessage())
                         .append(";")
        );
        return errorsMsg.toString();
    }
}
