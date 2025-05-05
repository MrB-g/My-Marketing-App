package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.PointHistoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PointHistoryCategoryRepository extends JpaRepository<PointHistoryCategory, Integer>, JpaSpecificationExecutor<PointHistoryCategory> {
}