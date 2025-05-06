package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer>, JpaSpecificationExecutor<Consumer> {
}