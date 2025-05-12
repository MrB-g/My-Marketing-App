package com.beeorg.mymarketing.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@Data
@SuperBuilder
@NoArgsConstructor
public class RangeLimitDto {

    @NotNull
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String typeName;

    @NotNull
    @Size(max = 100)
    private String typeSymbol;

    @NotNull
    @Size(max = 100)
    private String validity;
}
