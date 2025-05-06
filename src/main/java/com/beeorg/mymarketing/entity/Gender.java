package com.beeorg.mymarketing.entity;

import com.beeorg.mymarketing.entity.lib.PrimaryKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "gender", schema = "my_marketing")
public class Gender extends PrimaryKey {
    @Size(max = 20)
    @NotNull
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "gender")
    private Set<Consumer> consumers;

    @OneToMany(mappedBy = "gender")
    private Set<RewardGenderLimition> rewardGenderLimitions;

}