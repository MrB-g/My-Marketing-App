package com.beeorg.mymarketing.dto.lib;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDto {

    private String message;
}
