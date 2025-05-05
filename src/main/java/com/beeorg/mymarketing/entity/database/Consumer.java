package com.beeorg.mymarketing.entity.database;

import com.beeorg.mymarketing.entity.lib.PrimaryKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "consumer", schema = "my_marketing", indexes = {@Index(name = "consumer_email_unique", columnList = "email", unique = true)})
public class Consumer extends PrimaryKey {
    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotNull
    @Column(name = "registered_at", nullable = false)
    private Instant registeredAt;

    @OneToMany(mappedBy = "consumer")
    private Set<ConsumerPoint> consumerPoints;

    @OneToMany(mappedBy = "consumer")
    private Set<ConsumerPointHistory> consumerPointHistories;

    @OneToOne(mappedBy = "consumer")
    private Credential credential;

    @OneToMany(mappedBy = "consumer")
    private Set<RewardRedemptionHistory> rewardRedemptionHistories;

}