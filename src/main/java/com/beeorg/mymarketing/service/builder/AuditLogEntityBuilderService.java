package com.beeorg.mymarketing.service.builder;

import com.beeorg.mymarketing.dto.AuditLogDto;
import com.beeorg.mymarketing.entity.AuditLog;
import org.springframework.stereotype.Service;

@Service
public interface AuditLogEntityBuilderService extends
        BaseBuilderService<AuditLog, AuditLogDto>,
        UpdateBuilderService<AuditLog, AuditLogDto> {

}
