package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.RewardPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RewardPriceRepository extends JpaRepository<RewardPrice, Integer>, JpaSpecificationExecutor<RewardPrice> {
}