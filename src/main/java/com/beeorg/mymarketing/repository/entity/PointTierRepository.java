package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.PointTier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PointTierRepository extends JpaRepository<PointTier, Integer>, JpaSpecificationExecutor<PointTier> {
}