package com.beeorg.mymarketing.controller.api.dashboard;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.dto.DashboardUserUpdateDto;
import com.beeorg.mymarketing.dto.http.ResponseBody;
import com.beeorg.mymarketing.dto.enums.ResponseBodyStatusEnum;
import com.beeorg.mymarketing.dto.lib.ErrorDto;
import com.beeorg.mymarketing.service.DashboardUserService;
import com.beeorg.mymarketing.service.builder.ErrorValidationDtoBuilderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@BaseEndpoint
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

    @PostMapping("/v1/user")
    public ResponseEntity<?> create(@Valid @RequestBody DashboardUserDto user, Errors validationErrors) {
        if (validationErrors.hasErrors()) {
            List<ErrorDto> errors = errorValidationDtoBuilderService.buildValidationDtoList(validationErrors);
            return ResponseEntity.badRequest().body(new ResponseBody<>(ResponseBodyStatusEnum.ERROR, errors));
        }
        List<DashboardUserDto> responseDashboardUser = List.of(dashboardUserService.create(user));
        return ResponseEntity.ok(new ResponseBody<>(ResponseBodyStatusEnum.SUCCESS, responseDashboardUser));
    }

    @PutMapping("/v1/user")
    public ResponseEntity<?> update(@Valid @RequestBody DashboardUserUpdateDto user, Errors validationErrors) {
        if (validationErrors.hasErrors()) {
            List<ErrorDto> errors = errorValidationDtoBuilderService.buildValidationDtoList(validationErrors);
            return ResponseEntity.badRequest().body(new ResponseBody<>(ResponseBodyStatusEnum.ERROR, errors));
        }
        List<DashboardUserDto> responseDashboardUser = List.of(dashboardUserService.update(user));
        return ResponseEntity.ok(new ResponseBody<>(ResponseBodyStatusEnum.SUCCESS, responseDashboardUser));
    }

    @DeleteMapping("/v1/user/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        DashboardUserDto user = dashboardUserService.readDetail(id);
        if (user == null) {
            List<ErrorDto> error = List.of(ErrorDto.builder().errorMessage("User not found").build());
            return ResponseEntity.badRequest().body(new ResponseBody<>(ResponseBodyStatusEnum.ERROR, error));
        }
        List<DashboardUserDto> responseDashboardUser = List.of(dashboardUserService.delete(user));
        return ResponseEntity.ok(new ResponseBody<>(ResponseBodyStatusEnum.SUCCESS, responseDashboardUser));
    }

    @GetMapping("/v1/user/{id}")
    public ResponseEntity<?> readDetail(@PathVariable int id) {
        DashboardUserDto user = dashboardUserService.readDetail(id);
        if (user == null) {
            List<ErrorDto> error = List.of(ErrorDto.builder().errorMessage("User not found").build());
            return ResponseEntity.badRequest().body(new ResponseBody<>(ResponseBodyStatusEnum.ERROR, error));
        }
        List<DashboardUserDto> responseDashboardUser = List.of(user);
        return ResponseEntity.ok(new ResponseBody<>(ResponseBodyStatusEnum.SUCCESS, responseDashboardUser));
    }
}
