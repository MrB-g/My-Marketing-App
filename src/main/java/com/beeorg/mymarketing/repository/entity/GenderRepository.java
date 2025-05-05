package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.database.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenderRepository extends JpaRepository<Gender, Integer>, JpaSpecificationExecutor<Gender> {
}