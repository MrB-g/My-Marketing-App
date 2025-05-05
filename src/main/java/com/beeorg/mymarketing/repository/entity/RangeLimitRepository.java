package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.RangeLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RangeLimitRepository extends JpaRepository<RangeLimit, Integer>, JpaSpecificationExecutor<RangeLimit> {
}