package com.beeorg.mymarketing.entity;

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
@Table(name = "super_merchant", schema = "my_marketing")
@AttributeOverrides({@AttributeOverride(name = "createdBy", column = @Column(name = "created_by", nullable = false, length = 50)), @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", nullable = false, length = 50))})
public class SuperMerchant extends Base {
    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_system_id", nullable = false)
    private PointSystem pointSystem;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_tier_id", nullable = false)
    private PointTier pointTier;

    @OneToMany(mappedBy = "superMerchant")
    private Set<SubMerchant> subMerchants;

}