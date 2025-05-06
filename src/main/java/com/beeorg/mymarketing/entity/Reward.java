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
@Table(name = "reward", schema = "my_marketing")
@AttributeOverrides({@AttributeOverride(name = "createdBy", column = @Column(name = "created_by", nullable = false, length = 50)), @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", nullable = false, length = 50))})
public class Reward extends Base {
    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Size(max = 50)
    @Column(name = "img_url", length = 50)
    private String imgUrl;

    @Size(max = 50)
    @NotNull
    @Column(name = "expired_date_range", nullable = false, length = 50)
    private String expiredDateRange;

    @NotNull
    @Column(name = "inventory_count", nullable = false)
    private Integer inventoryCount;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reward_category_id", nullable = false)
    private RewardCategory rewardCategory;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reward_price_id", nullable = false)
    private RewardPrice rewardPrice;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "age_range_id", nullable = false)
    private AgeRange ageRange;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sub_merchant_id", nullable = false)
    private SubMerchant subMerchant;

    @OneToMany(mappedBy = "reward")
    private Set<RewardGenderLimition> rewardGenderLimitions;

    @OneToMany(mappedBy = "reward")
    private Set<RewardRedemptionHistory> rewardRedemptionHistories;

}