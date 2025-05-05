package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.PointHistoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PointHistoryStatusRepository extends JpaRepository<PointHistoryStatus, Integer>, JpaSpecificationExecutor<PointHistoryStatus> {
}