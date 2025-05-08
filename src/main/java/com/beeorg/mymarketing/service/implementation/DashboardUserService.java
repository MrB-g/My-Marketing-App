package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.dto.DashboardUserUpdateDto;
import com.beeorg.mymarketing.entity.DashboardUser;
import com.beeorg.mymarketing.repository.entity.DashboardUserRepository;
import com.beeorg.mymarketing.service.builder.DashboardUserEntityBuilderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public DashboardUserDto update(DashboardUserDto user) {
        DashboardUser dashboardUser = dashboardUserEntityBuilderService.build(user);
        dashboardUserRepository.update(dashboardUser);
        return user;
    }

    @Override
    public List<DashboardUserDto> read() {
        List<DashboardUser> dashboardUsers = dashboardUserRepository.findAll();
        return dashboardUsers.stream().map(dashboardUserEntityBuilderService::reverse).toList();
    }

    @Override
    public DashboardUserDto readDetail(int id) {
        Optional<DashboardUser> optionalUser = dashboardUserRepository.findById(id);
        return optionalUser.map(dashboardUserEntityBuilderService::reverse).orElse(null);
    }

    @Override
    public DashboardUserDto delete(DashboardUserDto user) {
        DashboardUser dashboardUser = dashboardUserEntityBuilderService.build(user);
        dashboardUserRepository.delete(dashboardUser);
        return dashboardUserEntityBuilderService.reverse(dashboardUser);
    }
}
