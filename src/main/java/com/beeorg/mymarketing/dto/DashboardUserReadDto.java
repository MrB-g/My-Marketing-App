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
public class DashboardUserReadDto {

    @NotNull(message = "Id is required")
    @Exists(table = "dashboard_user", message = "Provided user id does not exist")
    private Integer id;
}
