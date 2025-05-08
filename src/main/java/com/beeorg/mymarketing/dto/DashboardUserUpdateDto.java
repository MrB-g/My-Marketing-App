package com.beeorg.mymarketing.dto;

import com.beeorg.mymarketing.validation.annotation.NotDuplicate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class DashboardUserUpdateDto extends DashboardUserDto {

    @NotDuplicate(column = "id", table = "dashboard_user", reverse = true)
    @NotBlank(message = "Id is required")
    private Integer id;
}
