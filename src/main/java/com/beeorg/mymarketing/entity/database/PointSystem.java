package com.beeorg.mymarketing.entity.database;

import com.beeorg.mymarketing.entity.lib.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "point_system", schema = "my_marketing")
@AttributeOverrides({@AttributeOverride(name = "createdBy", column = @Column(name = "created_by", nullable = false, length = 50)), @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", nullable = false, length = 50))})
public class PointSystem extends Base {
    @Size(max = 50)
    @NotNull
    @Column(name = "expired_date_range", nullable = false, length = 50)
    private String expiredDateRange;

    @OneToMany(mappedBy = "pointSystem")
    private Set<SuperMerchant> superMerchants;

}