package com.beeorg.mymarketing.service;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.dto.DashboardUserReadDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DashboardUserService {

    DashboardUserDto create(DashboardUserDto user);

    DashboardUserDto update(DashboardUserDto user);

    List<DashboardUserDto> read();

    DashboardUserDto readDetail(DashboardUserReadDto user);

    DashboardUserDto delete(DashboardUserReadDto user);
}
