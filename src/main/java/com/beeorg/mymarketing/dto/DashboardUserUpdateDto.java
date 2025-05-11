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
public class DashboardUserUpdateDto extends DashboardUserDto {

    @NotNull(message = "Id is required")
    @Exists(table = "dashboard_user")
    private Integer id;
}
