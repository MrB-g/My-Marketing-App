package com.beeorg.mymarketing.repository.entity;

import com.beeorg.mymarketing.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CredentialRepository extends JpaRepository<Credential, Integer>, JpaSpecificationExecutor<Credential> {
}