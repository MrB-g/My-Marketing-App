package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.dto.DashboardUserUpdateDto;
import com.beeorg.mymarketing.entity.DashboardUser;
import org.springframework.stereotype.Service;

@Service
public class DashboardUserEntityBuilderService implements com.beeorg.mymarketing.service.builder.DashboardUserEntityBuilderService {

    @Override
    public DashboardUser build(DashboardUserDto user) {
        return DashboardUser.builder()
                .id(user.getId())
                .loginId(user.getLoginId())
                .password(user.getPassword())
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
