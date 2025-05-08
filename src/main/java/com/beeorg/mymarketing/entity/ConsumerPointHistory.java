package com.beeorg.mymarketing.entity;

import com.beeorg.mymarketing.entity.lib.PrimaryKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "consumer_point_history", schema = "my_marketing")
public class ConsumerPointHistory extends PrimaryKey {
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consumer_id", nullable = false)
    private Consumer consumer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sub_merchant_id", nullable = false)
    private SubMerchant subMerchant;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_history_status_id", nullable = false)
    private PointHistoryStatus pointHistoryStatus;

    @NotNull
    @Column(name = "total_points", nullable = false)
    private Integer totalPoints;

    @NotNull
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;
}