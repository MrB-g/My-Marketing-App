package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.RangeLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RangeLimitRepository extends JpaRepository<RangeLimit, Integer>, JpaSpecificationExecutor<RangeLimit> {

    List<RangeLimit> findByValidity(String validity);
}