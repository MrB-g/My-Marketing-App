package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.RewardGenderLimition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RewardGenderLimitionRepository extends JpaRepository<RewardGenderLimition, Integer>, JpaSpecificationExecutor<RewardGenderLimition> {
}