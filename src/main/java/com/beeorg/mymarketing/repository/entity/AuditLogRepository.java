package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.AuditLog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Integer>, JpaSpecificationExecutor<AuditLog> {

    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO my_marketing.audit_log (original_data, modified_data, end_point, function_name) VALUES(:originalData, :modifiedData, :endPoint, :functionName)",
            nativeQuery = true
    )
    void insert(String originalData, String modifiedData, String endPoint, String functionName);
}