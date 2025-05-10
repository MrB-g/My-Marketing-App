package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.DashboardUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardUserRepository extends JpaRepository<DashboardUser, Integer>, JpaSpecificationExecutor<DashboardUser> {

}