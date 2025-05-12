package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.entity.DashboardUser;
import com.beeorg.mymarketing.repository.entity.DashboardUserRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardUserEntityBuilderService implements com.beeorg.mymarketing.service.builder.DashboardUserEntityBuilderService {

    private final DashboardUserRepository dashboardUserRepository;

    public DashboardUserEntityBuilderService(DashboardUserRepository dashboardUserRepository) {
        this.dashboardUserRepository = dashboardUserRepository;
    }

    @Override
    public DashboardUser build(DashboardUserDto user) {
        return DashboardUser.builder()
                .id(user.getId())
                .loginId(user.getLoginId())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .createdBy(user.getCreatedBy())
                .updatedAt(user.getUpdatedAt())
                .updatedBy(user.getUpdatedBy())
                .build();
    }

    @Override
    public DashboardUser update(DashboardUserDto requestData) {
        DashboardUser dbUser = dashboardUserRepository.findById(requestData.getId()).orElse(new DashboardUser());
        return dbUser.toBuilder()
                .loginId(requestData.getLoginId() != null ? requestData.getLoginId() : dbUser.getLoginId())
                .password(requestData.getPassword() != null ? requestData.getPassword() : dbUser.getPassword())
                .build();
    }

    @Override
    public DashboardUserDto reverse(DashboardUser user) {
        return DashboardUserDto.builder()
                .id(user.getId())
                .loginId(user.getLoginId())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .createdBy(user.getCreatedBy())
                .updatedBy(user.getUpdatedBy())
                .build();
    }
}
