package com.beeorg.mymarketing.entity;

import com.beeorg.mymarketing.entity.lib.PrimaryKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "audit_log", schema = "my_marketing")
public class AuditLog extends PrimaryKey {
    @Column(name = "original_data")
    private String originalData;

    @Column(name = "modified_data")
    private String modifiedData;

    @NotNull
    @Column(name = "performed_at", nullable = false)
    private Instant performedAt;

    @Size(max = 100)
    @NotNull
    @Column(name = "end_point", nullable = false, length = 100)
    private String endPoint;

    @Size(max = 100)
    @NotNull
    @Column(name = "function_name", nullable = false, length = 100)
    private String functionName;
}