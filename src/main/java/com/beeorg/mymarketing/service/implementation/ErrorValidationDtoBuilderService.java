package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.lib.ErrorDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Optional;

@Service
public class ErrorValidationDtoBuilderService implements com.beeorg.mymarketing.service.builder.ErrorValidationDtoBuilderService {

    @Override
    public List<ErrorDto> buildValidationDtoList(Errors validationErrors) {
        List<FieldError> fieldErrorList = validationErrors.getFieldErrors();
        if (fieldErrorList.isEmpty()) {
            List<ObjectError> objectErrorList = validationErrors.getGlobalErrors();
            return objectErrorList.stream().map(this::buildValidationDto).toList();
        }
        return fieldErrorList.stream().map(this::buildValidationDto).toList();
    }

    private ErrorDto buildValidationDto(FieldError fieldError) {
        String field = fieldError.getField();
        Optional<Object> rejectedValueOptional = Optional.ofNullable(fieldError.getRejectedValue());
        String rejectedValue = rejectedValueOptional.map(Object::toString).orElse(null);
        String errorMessage = fieldError.getDefaultMessage();
        return ErrorDto.builder().field(field).rejectedValue(rejectedValue).errorMessage(errorMessage).build();
    }

    private ErrorDto buildValidationDto(ObjectError objectError) {
        String errorMessage = objectError.getDefaultMessage();
        return ErrorDto.builder().errorMessage(errorMessage).build();
    }
}