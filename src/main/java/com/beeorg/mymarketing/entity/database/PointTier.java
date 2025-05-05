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
@Table(name = "point_tier", schema = "my_marketing")
@AttributeOverrides({@AttributeOverride(name = "createdBy", column = @Column(name = "created_by", nullable = false, length = 50)), @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", nullable = false, length = 50))})
public class PointTier extends Base {
    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "from_point")
    private Integer fromPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_point_limit_id")
    private RangeLimit fromPointLimit;

    @Column(name = "to_point")
    private Integer toPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_point_limit_id")
    private RangeLimit toPointLimit;

    @Size(max = 100)
    @Column(name = "icon_url", length = 100)
    private String iconUrl;

    @OneToMany(mappedBy = "pointTier")
    private Set<SuperMerchant> superMerchants;

}