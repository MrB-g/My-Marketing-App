package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RewardRepository extends JpaRepository<Reward, Integer>, JpaSpecificationExecutor<Reward> {
}