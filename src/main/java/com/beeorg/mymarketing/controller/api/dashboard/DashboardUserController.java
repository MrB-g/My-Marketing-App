package com.beeorg.mymarketing.controller.api.dashboard;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.dto.lib.ValidationDto;
import com.beeorg.mymarketing.dto.http.ErrorResponseBody;
import com.beeorg.mymarketing.service.DashboardUserService;
import com.beeorg.mymarketing.service.builder.ErrorValidationDtoBuilderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/dashboard/user")
public class DashboardUserController {

    private final ErrorValidationDtoBuilderService errorValidationDtoBuilderService;

    private final DashboardUserService dashboardUserService;

    public DashboardUserController(
            ErrorValidationDtoBuilderService errorValidationDtoBuilderService,
            DashboardUserService dashboardUserService
    ) {
        this.errorValidationDtoBuilderService = errorValidationDtoBuilderService;
        this.dashboardUserService = dashboardUserService;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DashboardUserDto user, Errors validationErrors) {
        if (validationErrors.hasErrors()) {
            List<ValidationDto> errors = errorValidationDtoBuilderService.buildValidationDtoList(validationErrors);
            ErrorResponseBody<List<ValidationDto>> errorResponseBody = new ErrorResponseBody<>(true, errors);
            return ResponseEntity.badRequest().body(errorResponseBody);
        }
        DashboardUserDto responseDashboardUser = dashboardUserService.create(user);
        return ResponseEntity.ok(responseDashboardUser);
    }

    @GetMapping
    public ResponseEntity<?> read() {
        List<DashboardUserDto> users = dashboardUserService.read();
        return ResponseEntity.ok(users);
    }
}
