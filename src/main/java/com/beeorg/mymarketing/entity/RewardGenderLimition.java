package com.beeorg.mymarketing.entity;

import com.beeorg.mymarketing.entity.lib.PrimaryKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "reward_gender_limition", schema = "my_marketing")
public class RewardGenderLimition extends PrimaryKey {
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reward_id", nullable = false)
    private Reward reward;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

}