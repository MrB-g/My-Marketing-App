package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.AuditLogDto;
import com.beeorg.mymarketing.entity.AuditLog;
import com.beeorg.mymarketing.repository.entity.AuditLogRepository;
import com.beeorg.mymarketing.service.builder.AuditLogEntityBuilderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditLogService implements com.beeorg.mymarketing.service.AuditLogService {

    private final AuditLogRepository auditLogRepository;

    private final AuditLogEntityBuilderService auditLogEntityBuilderService;

    public AuditLogService(AuditLogRepository auditLogRepository, AuditLogEntityBuilderService auditLogEntityBuilderService) {
        this.auditLogRepository = auditLogRepository;
        this.auditLogEntityBuilderService = auditLogEntityBuilderService;
    }

    @Override
    public AuditLogDto create(AuditLogDto audit) {
        auditLogRepository.insert(audit.getOriginalData(), audit.getModifiedData(), audit.getEndPoint(), audit.getFunctionName());
        return audit;
    }

    @Override
    public AuditLogDto update(AuditLogDto audit) {
        AuditLog auditLogEntity = auditLogEntityBuilderService.build(audit);
        auditLogRepository.update(auditLogEntity);
        return audit;
    }

    @Override
    public List<AuditLogDto> read() {
        List<AuditLog> auditLogs = auditLogRepository.findAll();
        return auditLogs.stream().map(auditLogEntityBuilderService::reverse).toList();
    }

    @Override
    public AuditLogDto readDetail(int id) {
        Optional<AuditLog> audit = auditLogRepository.findById(id);
        return audit.map(auditLogEntityBuilderService::reverse).orElse(null);
    }
}