package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.ConsumerPointHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConsumerPointHistoryRepository extends JpaRepository<ConsumerPointHistory, Integer>, JpaSpecificationExecutor<ConsumerPointHistory> {
}