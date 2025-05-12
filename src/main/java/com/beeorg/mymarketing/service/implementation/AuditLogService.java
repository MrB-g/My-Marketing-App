package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.AuditLogDto;
import com.beeorg.mymarketing.entity.AuditLog;
import com.beeorg.mymarketing.repository.entity.AuditLogRepository;
import com.beeorg.mymarketing.service.builder.AuditLogEntityBuilderService;
import com.beeorg.mymarketing.service.handler.CrudServiceHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService implements com.beeorg.mymarketing.service.AuditLogService {

    private final AuditLogRepository auditLogRepository;

    private final AuditLogEntityBuilderService auditLogEntityBuilderService;

    public AuditLogService(
            AuditLogRepository auditLogRepository,
            AuditLogEntityBuilderService auditLogEntityBuilderService
    ) {
        this.auditLogRepository = auditLogRepository;
        this.auditLogEntityBuilderService = auditLogEntityBuilderService;
    }

    @Override
    public AuditLogDto create(AuditLogDto audit) {
        return CrudServiceHandler.save(
                audit,
                auditLogEntityBuilderService::build,
                auditLogRepository::save,
                auditLogEntityBuilderService::reverse
        );
    }

    @Override
    public AuditLogDto update(AuditLogDto audit) {
        return CrudServiceHandler.update(
                audit,
                auditLogEntityBuilderService::update,
                auditLogRepository::save,
                auditLogEntityBuilderService::reverse
        );
    }

    @Override
    public List<AuditLogDto> read() {
        return CrudServiceHandler.read(
                auditLogRepository::findAll,
                auditLogEntityBuilderService::reverse
        );
    }

    @Override
    public AuditLogDto readDetail(int id) {
        return CrudServiceHandler.readDetail(
                id,
                auditLogRepository::findById,
                AuditLog::new,
                auditLogEntityBuilderService::reverse
        );
    }
}