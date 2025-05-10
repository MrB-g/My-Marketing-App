package com.beeorg.mymarketing.service;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DashboardUserService {

    DashboardUserDto create(DashboardUserDto user);

    DashboardUserDto update(DashboardUserDto user);

    List<DashboardUserDto> read();

    DashboardUserDto readDetail(int id);

    DashboardUserDto delete(DashboardUserDto user);
}
