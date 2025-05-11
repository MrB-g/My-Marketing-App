package com.beeorg.mymarketing.entity.lib;

import com.beeorg.mymarketing.dto.enums.DefaultUserEnum;
import jakarta.persistence.*;
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
@MappedSuperclass
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id"))})
public class Base extends PrimaryKey {

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Size(max = 50)
    @Column(name = "created_by", updatable = false, nullable = false)
    private String createdBy;

    @Column(name = "updated_at", insertable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Size(max = 50)
    @Column(name = "updated_by", insertable = false, nullable = false)
    private String updatedBy;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.createdBy = DefaultUserEnum.SYSTEM.name();
        this.updatedBy = DefaultUserEnum.SYSTEM.name();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = DefaultUserEnum.SYSTEM.name();
    }
}