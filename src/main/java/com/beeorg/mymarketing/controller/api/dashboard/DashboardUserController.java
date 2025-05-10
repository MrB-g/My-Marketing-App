package com.beeorg.mymarketing.controller.api.dashboard;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.dto.DashboardUserReadDto;
import com.beeorg.mymarketing.dto.DashboardUserUpdateDto;
import com.beeorg.mymarketing.service.DashboardUserService;
import com.beeorg.mymarketing.service.handler.CrudEndpointHandler;
import com.beeorg.mymarketing.service.implementation.ResponseEntityBuilderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@BaseEndpoint
public class DashboardUserController {

    private final DashboardUserService dashboardUserService;

    private final ResponseEntityBuilderService<DashboardUserDto> responseEntityBuilderService;

    public DashboardUserController(
            DashboardUserService dashboardUserService,
            ResponseEntityBuilderService<DashboardUserDto> responseEntityBuilderService
    ) {
        this.dashboardUserService = dashboardUserService;
        this.responseEntityBuilderService = responseEntityBuilderService;
    }

    @PostMapping("/v1/user")
    public ResponseEntity<?> create(@Valid @RequestBody DashboardUserDto user, Errors validationErrors) {
        return CrudEndpointHandler.run(dashboardUserService::create, user, validationErrors, responseEntityBuilderService);
    }

    @PutMapping("/v1/user")
    public ResponseEntity<?> update(@Valid @RequestBody DashboardUserUpdateDto user, Errors validationErrors) {
        return CrudEndpointHandler.run(dashboardUserService::update, user, validationErrors, responseEntityBuilderService);
    }

    @DeleteMapping("/v1/user")
    public ResponseEntity<?> delete(@Valid @RequestBody DashboardUserReadDto user, Errors validationErrors) {
        return CrudEndpointHandler.run(dashboardUserService::delete, user, validationErrors, responseEntityBuilderService);
    }

    @GetMapping("/v1/user")
    public ResponseEntity<?> readDetail(@Valid @RequestBody DashboardUserReadDto user, Errors validationErrors) {
        return CrudEndpointHandler.run(dashboardUserService::readDetail, user, validationErrors, responseEntityBuilderService);
    }
}
