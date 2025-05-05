package com.beeorg.mymarketing.entity.database;

import com.beeorg.mymarketing.entity.lib.PrimaryKey;
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
@Table(name = "point_history_status", schema = "my_marketing")
public class PointHistoryStatus extends PrimaryKey {
    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_category_id", nullable = false)
    private PointHistoryCategory pointCategory;

    @OneToMany(mappedBy = "pointHistoryStatus")
    private Set<ConsumerPointHistory> consumerPointHistories;

}