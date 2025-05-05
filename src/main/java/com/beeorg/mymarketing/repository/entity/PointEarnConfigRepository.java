package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.PointEarnConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PointEarnConfigRepository extends JpaRepository<PointEarnConfig, Integer>, JpaSpecificationExecutor<PointEarnConfig> {
}