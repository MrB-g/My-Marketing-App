package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.DashboardUserDto;
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

    public DashboardUserService(
            DashboardUserRepository dashboardUserRepository,
            DashboardUserEntityBuilderService dashboardUserEntityBuilderService
    ) {
        this.dashboardUserRepository = dashboardUserRepository;
        this.dashboardUserEntityBuilderService = dashboardUserEntityBuilderService;
    }

    @Override
    public DashboardUserDto create(DashboardUserDto user) {
        DashboardUser dashboardUser = dashboardUserEntityBuilderService.build(user);
        DashboardUser savedUser = dashboardUserRepository.save(dashboardUser);
        return dashboardUserEntityBuilderService.reverse(savedUser);
    }

    @Override
    public DashboardUserDto update(DashboardUserDto user) {
        DashboardUser dbUser = dashboardUserRepository.findById(user.getId()).get();
        DashboardUser requestUser = dashboardUserEntityBuilderService.update(user, dbUser);
        DashboardUser updateUser = dashboardUserRepository.save(requestUser);
        return dashboardUserEntityBuilderService.reverse(updateUser);
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
        return user;
    }
}
