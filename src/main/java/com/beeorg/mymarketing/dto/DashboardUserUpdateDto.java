package com.beeorg.mymarketing.dto;

import com.beeorg.mymarketing.validation.annotation.NotDuplicate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class DashboardUserUpdateDto extends DashboardUserDto {

    @NotNull(message = "Id is required")
    @NotDuplicate(column = "id", table = "dashboard_user", reverse = true)
    private Integer id;
}
