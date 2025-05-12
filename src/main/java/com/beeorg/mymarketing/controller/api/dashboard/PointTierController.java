package com.beeorg.mymarketing.controller.api.dashboard;

import com.beeorg.mymarketing.aspect.dashboard.annotation.EnableAuditLog;
import com.beeorg.mymarketing.dto.PointTierDto;
import com.beeorg.mymarketing.dto.PointTierReadDto;
import com.beeorg.mymarketing.dto.PointTierUpdateDto;
import com.beeorg.mymarketing.service.handler.CrudEndpointHandler;
import com.beeorg.mymarketing.service.implementation.PointTierService;
import com.beeorg.mymarketing.service.implementation.ResponseEntityBuilderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@BaseEndpoint
public class PointTierController {

    private final PointTierService pointTierService;

    private final ResponseEntityBuilderService<PointTierDto> responseEntityBuilderService;

    public PointTierController(PointTierService pointTierService, ResponseEntityBuilderService<PointTierDto> responseEntityBuilderService) {
        this.pointTierService = pointTierService;
        this.responseEntityBuilderService = responseEntityBuilderService;
    }

    @PostMapping("/v1/user")
    @EnableAuditLog
    public ResponseEntity<?> create(@Valid @RequestBody PointTierDto pointTier, Errors validationErrors) {
        return CrudEndpointHandler.run(pointTierService::create, pointTier, validationErrors, responseEntityBuilderService);
    }

    @PutMapping("/v1/user")
    @EnableAuditLog
    public ResponseEntity<?> update(@Valid @RequestBody PointTierUpdateDto pointTier, Errors validationErrors) {
        return CrudEndpointHandler.run(pointTierService::update, pointTier, validationErrors, responseEntityBuilderService);
    }

    @DeleteMapping("/v1/user")
    @EnableAuditLog
    public ResponseEntity<?> delete(@Valid @RequestBody PointTierReadDto pointTier, Errors validationErrors) {
        return CrudEndpointHandler.run(pointTierService::delete, pointTier, validationErrors, responseEntityBuilderService);
    }

    @GetMapping("/v1/user")
    @EnableAuditLog
    public ResponseEntity<?> readDetail(@Valid @RequestBody PointTierReadDto pointTier, Errors validationErrors) {
        return CrudEndpointHandler.run(pointTierService::readDetail, pointTier, validationErrors, responseEntityBuilderService);
    }
}
