package com.beeorg.mymarketing.dto;

import com.beeorg.mymarketing.dto.lib.BaseDto;
import com.beeorg.mymarketing.validation.annotation.FromRangeLimit;
import com.beeorg.mymarketing.validation.annotation.ToRangeLimit;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class PointTierDto extends BaseDto {

    @Size(max = 100, message = "Name must be maximum 100 characters long")
    @NotNull(message = "Name is required")
    private String name;

    private Integer fromPoint;

    @FromRangeLimit
    private Integer fromPointLimitId;

    private Integer toPoint;

    @ToRangeLimit
    private Integer toPointLimitId;

    @Size(max = 100, message = "Icon url must be maximum 100 characters long")
    private String iconUrl;
}
