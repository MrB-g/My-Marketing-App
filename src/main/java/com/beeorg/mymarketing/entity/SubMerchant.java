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
@Table(name = "sub_merchant", schema = "my_marketing")
@AttributeOverrides({
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "created_by", length = 50)),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", length = 50))
})
public class SubMerchant extends Base {
    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Size(max = 100)
    @NotNull
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Size(max = 50)
    @NotNull
    @Column(name = "login_id", nullable = false, length = 50)
    private String loginId;

    @Size(max = 100)
    @Column(name = "address", length = 100)
    private String address;

    @Size(max = 100)
    @Column(name = "phone_number", length = 100)
    private String phoneNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "super_merchant_id", nullable = false)
    private SuperMerchant superMerchant;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_earn_config_id", nullable = false)
    private PointEarnConfig pointEarnConfig;

    @OneToMany(mappedBy = "subMerchant")
    private Set<ConsumerPoint> consumerPoints;

    @OneToMany(mappedBy = "subMerchant")
    private Set<ConsumerPointHistory> consumerPointHistories;

    @OneToMany(mappedBy = "subMerchant")
    private Set<Reward> rewards;

}