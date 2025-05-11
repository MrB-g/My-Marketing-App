package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.AuditLogDto;
import com.beeorg.mymarketing.entity.AuditLog;
import org.springframework.stereotype.Service;

@Service
public class AuditLogEntityBuilderService implements com.beeorg.mymarketing.service.builder.AuditLogEntityBuilderService {

    @Override
    public AuditLog build(AuditLogDto audit) {
        return AuditLog.builder()
                .originalData(audit.getOriginalData())
                .modifiedData(audit.getModifiedData())
                .performedAt(audit.getPerformedAt())
                .endPoint(audit.getEndPoint())
                .functionName(audit.getFunctionName())
                .performedBy(audit.getPerformedBy())
                .build();
    }

    @Override
    public AuditLog update(AuditLogDto requestData, AuditLog dbData) {
        return dbData.toBuilder()
                .modifiedData(requestData.getModifiedData() != null ? requestData.getModifiedData() : dbData.getModifiedData())
                .build();
    }

    @Override
    public AuditLogDto reverse(AuditLog audit) {
        return AuditLogDto.builder()
                .originalData(audit.getOriginalData())
                .modifiedData(audit.getModifiedData())
                .performedAt(audit.getPerformedAt())
                .endPoint(audit.getEndPoint())
                .functionName(audit.getFunctionName())
                .performedBy(audit.getPerformedBy())
                .build();
    }
}
