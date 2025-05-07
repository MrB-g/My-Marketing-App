package com.beeorg.mymarketing.entity.lib;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id"))})
public class Base extends PrimaryKey {

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Size(max = 50)
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Size(max = 50)
    @Column(name = "updated_by", insertable = false)
    private String updatedBy;
}