package com.beeorg.mymarketing.dto;

import com.beeorg.mymarketing.dto.lib.BaseDto;
import com.beeorg.mymarketing.validation.annotation.NotDuplicate;
import com.beeorg.mymarketing.validation.annotation.PasswordMatches;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@PasswordMatches(passwordField = "password", confirmPasswordField = "confirmPassword")
public class DashboardUserDto extends BaseDto {

    @Size(max = 20, message = "Login id must be maximum 20 characters long")
    @NotDuplicate(column = "login_id", table = "dashboard_user")
    @NotBlank(message = "Login id is required")
    private String loginId;

    @Size(max = 10, message = "Password must be maximum 10 characters long")
    @NotBlank(message = "Password is required")
    private String password;

    @Size(max = 10, message = "Confirm password must be maximum 10 characters long")
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;
}