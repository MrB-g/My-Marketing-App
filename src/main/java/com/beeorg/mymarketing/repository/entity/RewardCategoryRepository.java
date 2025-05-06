package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.RewardCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RewardCategoryRepository extends JpaRepository<RewardCategory, Integer>, JpaSpecificationExecutor<RewardCategory> {
}