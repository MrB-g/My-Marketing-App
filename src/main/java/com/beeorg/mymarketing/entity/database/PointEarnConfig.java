package com.beeorg.mymarketing.entity.database;

import com.beeorg.mymarketing.entity.lib.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "point_earn_config", schema = "my_marketing")
@AttributeOverrides({@AttributeOverride(name = "createdBy", column = @Column(name = "created_by", nullable = false, length = 50)), @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", nullable = false, length = 50))})
public class PointEarnConfig extends Base {
    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Column(name = "transaction_amount", nullable = false, precision = 20, scale = 2)
    private BigDecimal transactionAmount;

    @NotNull
    @Column(name = "no_of_points", nullable = false)
    private Integer noOfPoints;

    @OneToMany(mappedBy = "pointEarnConfig")
    private Set<SubMerchant> subMerchants;

}