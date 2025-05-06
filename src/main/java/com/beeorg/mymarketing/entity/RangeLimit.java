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

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "range_limit", schema = "my_marketing")
public class RangeLimit extends PrimaryKey {
    @Size(max = 100)
    @NotNull
    @Column(name = "type_name", nullable = false, length = 100)
    private String typeName;

    @Size(max = 100)
    @NotNull
    @Column(name = "type_symbol", nullable = false, length = 100)
    private String typeSymbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "validity", nullable = false, length = 100)
    private String validity;

}