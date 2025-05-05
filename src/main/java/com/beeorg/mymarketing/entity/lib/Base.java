package com.beeorg.mymarketing.entity.lib;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class Base extends PrimaryKey {

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Max(value = 50)
    @Column(name = "created_by", updatable = false, nullable = false)
    private String createdBy;

    @Column(name = "updated_at", insertable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Max(value = 50)
    @Column(name = "updated_by", insertable = false, nullable = false)
    private String updatedBy;
}