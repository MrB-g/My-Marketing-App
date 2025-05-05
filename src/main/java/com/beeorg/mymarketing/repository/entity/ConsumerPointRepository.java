package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.ConsumerPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConsumerPointRepository extends JpaRepository<ConsumerPoint, Integer>, JpaSpecificationExecutor<ConsumerPoint> {
}