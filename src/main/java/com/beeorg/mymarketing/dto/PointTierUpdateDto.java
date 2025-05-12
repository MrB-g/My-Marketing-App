package com.beeorg.mymarketing.dto;

import com.beeorg.mymarketing.validation.annotation.Exists;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class PointTierUpdateDto extends PointTierDto {

    @NotNull(message = "Id is required")
    @Exists(table = "point_tier", message = "Provided point tier id does not exist")
    private Integer id;
}
