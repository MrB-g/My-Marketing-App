package com.beeorg.mymarketing.dto.lib;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {

    private String field;

    private String rejectedValue;

    private String errorMessage;
}
