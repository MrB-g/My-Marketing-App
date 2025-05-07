package com.beeorg.mymarketing.dto.lib;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationDto {

    private String field;

    private String rejectedValue;

    private String errorMessage;
}
