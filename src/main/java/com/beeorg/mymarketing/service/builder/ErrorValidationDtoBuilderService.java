package com.beeorg.mymarketing.service.builder;

import com.beeorg.mymarketing.dto.lib.ValidationDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public interface ErrorValidationDtoBuilderService {

    List<ValidationDto> buildValidationDtoList(Errors validationErrors);
}
