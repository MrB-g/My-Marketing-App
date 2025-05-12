package com.beeorg.mymarketing.entity;

import com.beeorg.mymarketing.dto.enums.DefaultUserEnum;
import com.beeorg.mymarketing.entity.lib.PrimaryKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Entity
@Table(name = "audit_log", schema = "my_marketing")
public class AuditLog extends PrimaryKey {
    @Column(name = "request_data")
    private String requestData;

    @Column(name = "response_data")
    private String responseData;

    @NotNull
    @Column(name = "performed_at", nullable = false, updatable = false)
    private LocalDateTime performedAt;

    @Size(max = 100)
    @NotNull
    @Column(name = "end_point", nullable = false, length = 100)
    private String endPoint;

    @Size(max = 100)
    @NotNull
    @Column(name = "function_name", nullable = false, length = 100)
    private String functionName;

    @Size(max = 100)
    @NotNull
    @Column(name = "performed_by", nullable = false, length = 100, updatable = false)
    private String performedBy;

    @PrePersist
    public void onCreate() {
        this.performedAt = LocalDateTime.now();
        this.performedBy = DefaultUserEnum.SYSTEM.name();
    }
}