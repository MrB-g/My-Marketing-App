package com.beeorg.mymarketing.service;

import com.beeorg.mymarketing.dto.AuditLogDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuditLogService {

    AuditLogDto create(AuditLogDto audit);

    List<AuditLogDto> read();

    AuditLogDto readDetail(int id);
}
