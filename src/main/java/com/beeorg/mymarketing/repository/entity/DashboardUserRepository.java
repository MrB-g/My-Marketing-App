package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.DashboardUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardUserRepository extends JpaRepository<DashboardUser, Integer>, JpaSpecificationExecutor<DashboardUser> {

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO my_marketing.dashboard_user(login_id, password) VALUES(:loginId, :password)",
            nativeQuery = true
    )
    void insert(String loginId, String password);

    @Modifying
    @Transactional
    @Query("UPDATE DashboardUser u SET u.loginId = :#{#user.loginId}, u.password = :#{#user.password} WHERE u.id = :#{#user.id}")
    void update(@Param("user") DashboardUser user);
}