package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.entity.DashboardUser;
import com.beeorg.mymarketing.repository.entity.DashboardUserRepository;
import com.beeorg.mymarketing.service.builder.DashboardUserEntityBuilderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardUserService implements com.beeorg.mymarketing.service.DashboardUserService {

    private final DashboardUserRepository dashboardUserRepository;

    private final DashboardUserEntityBuilderService dashboardUserEntityBuilderService;

    public DashboardUserService(DashboardUserRepository dashboardUserRepository, DashboardUserEntityBuilderService dashboardUserEntityBuilderService) {
        this.dashboardUserRepository = dashboardUserRepository;
        this.dashboardUserEntityBuilderService = dashboardUserEntityBuilderService;
    }

    @Override
    public DashboardUserDto create(DashboardUserDto user) {
        dashboardUserRepository.insert(user.getLoginId(), user.getPassword());
        return user;
    }

    @Override
    public List<DashboardUserDto> read() {
        List<DashboardUser> users = dashboardUserRepository.findAll();
        return users.stream().map(dashboardUserEntityBuilderService::reverse).toList();
    }
}
