package com.beeorg.mymarketing.dto;

import com.beeorg.mymarketing.validation.annotation.Exists;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointTierReadDto {

    @NotNull(message = "Id is required")
    @Exists(table = "point_tier", message = "Provided point tier id does not exist")
    private Integer id;
}