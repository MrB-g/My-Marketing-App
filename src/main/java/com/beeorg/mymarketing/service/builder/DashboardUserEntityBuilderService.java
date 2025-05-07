package com.beeorg.mymarketing.service.builder;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.entity.DashboardUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DashboardUserEntityBuilderService {

    DashboardUser build(DashboardUserDto user);

    DashboardUserDto reverse(DashboardUser user);
}
