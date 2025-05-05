package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.SuperMerchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SuperMerchantRepository extends JpaRepository<SuperMerchant, Integer>, JpaSpecificationExecutor<SuperMerchant> {
}