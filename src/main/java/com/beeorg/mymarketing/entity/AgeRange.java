package com.beeorg.mymarketing.entity;

import com.beeorg.mymarketing.entity.lib.Base;
import jakarta.persistence.*;
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
@Table(name = "age_range", schema = "my_marketing")
@AttributeOverrides({@AttributeOverride(name = "createdBy", column = @Column(name = "created_by", nullable = false, length = 50)), @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", nullable = false, length = 50))})
public class AgeRange extends Base {
    @Column(name = "from_age")
    private Integer fromAge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_age_limit_id")
    private RangeLimit fromAgeLimit;

    @Column(name = "to_age")
    private Integer toAge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_age_limit_id")
    private RangeLimit toAgeLimit;

    @OneToMany(mappedBy = "ageRange")
    private Set<Reward> rewards;

}