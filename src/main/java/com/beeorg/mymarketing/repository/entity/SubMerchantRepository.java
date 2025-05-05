package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.SubMerchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubMerchantRepository extends JpaRepository<SubMerchant, Integer>, JpaSpecificationExecutor<SubMerchant> {
}