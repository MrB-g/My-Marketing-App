package com.beeorg.mymarketing.service.builder;

import com.beeorg.mymarketing.dto.lib.ErrorDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public interface ErrorValidationDtoBuilderService {

    List<ErrorDto> buildValidationDtoList(Errors validationErrors);
}
