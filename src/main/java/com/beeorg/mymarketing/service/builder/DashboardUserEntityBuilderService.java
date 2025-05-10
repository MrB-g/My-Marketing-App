package com.beeorg.mymarketing.service.builder;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.entity.DashboardUser;
import org.springframework.stereotype.Service;

@Service
public interface DashboardUserEntityBuilderService extends
        BaseBuilderService<DashboardUser, DashboardUserDto>,
        UpdateBuilderService<DashboardUser, DashboardUserDto> {

}
