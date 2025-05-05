package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.DashboardUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DashboardUserRepository extends JpaRepository<DashboardUser, Integer>, JpaSpecificationExecutor<DashboardUser> {
}