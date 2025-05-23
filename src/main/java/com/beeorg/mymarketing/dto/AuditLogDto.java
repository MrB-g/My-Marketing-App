package com.beeorg.mymarketing.dto;

import com.beeorg.mymarketing.dto.lib.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class AuditLogDto extends BaseDto {

    private String requestData;

    private String responseData;

    private LocalDateTime performedAt;

    @Size(max = 100)
    @NotNull
    private String endPoint;

    @Size(max = 100)
    @NotNull
    private String functionName;

    @Size(max = 100)
    @NotNull
    private String performedBy;
}
