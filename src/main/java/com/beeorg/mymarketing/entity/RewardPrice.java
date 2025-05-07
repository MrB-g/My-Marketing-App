package com.beeorg.mymarketing.entity;

import com.beeorg.mymarketing.entity.lib.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "reward_price", schema = "my_marketing")
@AttributeOverrides({
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "created_by", length = 50)),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", length = 50))
})
public class RewardPrice extends Base {
    @NotNull
    @Column(name = "total_points", nullable = false)
    private Integer totalPoints;

    @OneToMany(mappedBy = "rewardPrice")
    private Set<Reward> rewards;

}