package com.beeorg.mymarketing.aspect.dashboard;

import com.beeorg.mymarketing.dto.AuditLogDto;
import com.beeorg.mymarketing.dto.enums.ResponseBodyStatusEnum;
import com.beeorg.mymarketing.dto.http.ResponseBody;
import com.beeorg.mymarketing.service.AuditLogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
public class AuditLogAspect {

    private final AuditLogService auditLogService;

    private final ObjectMapper objectMapper;

    public AuditLogAspect(AuditLogService auditLogService, ObjectMapper objectMapper) {
        this.auditLogService = auditLogService;
        this.objectMapper = objectMapper;
    }

    @Around("@annotation(com.beeorg.mymarketing.aspect.dashboard.annotation.EnableAuditLog)")
    public Object run(ProceedingJoinPoint joinPoint) throws Throwable {
        Object responseData = joinPoint.proceed();
        Optional<String> responseStatus = extractResponseStatus(responseData);
        if (responseStatus.isPresent() && responseStatus.get().equals(ResponseBodyStatusEnum.SUCCESS.name())) {
            String responseDataJson = objectMapper.writeValueAsString(responseData);
            Object requestData = joinPoint.getArgs()[0];
            String requestDataJson = objectMapper.writeValueAsString(requestData);
            AuditLogDto auditLogData = extractAuditLogData(joinPoint);
            AuditLogDto savedAuditLogData = auditLogData.toBuilder()
                    .originalData(requestDataJson)
                    .modifiedData(responseDataJson)
                    .build();
            auditLogService.create(savedAuditLogData);
        }
        return responseData;
    }

    private Optional<String> extractResponseStatus(Object responseData) {
        var responseEntity = (ResponseEntity<?>) responseData;
        var responseBody = (ResponseBody<?>) responseEntity.getBody();
        if (Optional.ofNullable(responseBody).isPresent()) {
            return Optional.of(responseBody.getStatus());
        }
        return Optional.empty();
    }

    private AuditLogDto extractAuditLogData(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        StringBuilder functionName = extractFunctionName(signature);
        StringBuilder endPoint = extractEndPoint(signature);
        return AuditLogDto.builder().functionName(functionName.toString()).endPoint(endPoint.toString()).build();
    }

    private StringBuilder extractFunctionName(MethodSignature signature) {
        StringBuilder functionName = new StringBuilder();
        functionName.append(signature.getDeclaringTypeName()).append(".").append(signature.getMethod().getName());
        return functionName;
    }

    private StringBuilder extractEndPoint(MethodSignature signature) {
        StringBuilder endPoint = new StringBuilder();
        Method method = signature.getMethod();
        if (method.isAnnotationPresent(GetMapping.class)) {
            GetMapping getMapping = method.getAnnotation(GetMapping.class);
            endPoint.append("[GET]");
            endPoint.append(Arrays.toString(getMapping.value()));
        } else if (method.isAnnotationPresent(PostMapping.class)) {
            PostMapping postMapping = method.getAnnotation(PostMapping.class);
            endPoint.append("[POST]");
            endPoint.append(Arrays.toString(postMapping.value()));
        } else if (method.isAnnotationPresent(PutMapping.class)) {
            PutMapping putMapping = method.getAnnotation(PutMapping.class);
            endPoint.append("[PUT]");
            endPoint.append(Arrays.toString(putMapping.value()));
        } else if (method.isAnnotationPresent(DeleteMapping.class)) {
            DeleteMapping deleteMapping = method.getAnnotation(DeleteMapping.class);
            endPoint.append("[DELETE]");
            endPoint.append(Arrays.toString(deleteMapping.value()));
        } else if (method.isAnnotationPresent(RequestMapping.class)) {
            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
            endPoint.append("[]");
            endPoint.append(Arrays.toString(requestMapping.value()));
        }
        return endPoint;
    }
}
