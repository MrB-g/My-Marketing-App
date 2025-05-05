package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.AgeRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AgeRangeRepository extends JpaRepository<AgeRange, Integer>, JpaSpecificationExecutor<AgeRange> {
}