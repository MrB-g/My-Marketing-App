package com.beeorg.mymarketing.dto;

import com.beeorg.mymarketing.validation.annotation.PasswordMatches;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@PasswordMatches
public class DashboardUserDto {

    private String loginId;

    private String password;

    private String confirmPassword;
}