package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.PointSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PointSystemRepository extends JpaRepository<PointSystem, Integer>, JpaSpecificationExecutor<PointSystem> {
}