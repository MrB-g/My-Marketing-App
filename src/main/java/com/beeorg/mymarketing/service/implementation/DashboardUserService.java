package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.DashboardUserDto;
import com.beeorg.mymarketing.dto.DashboardUserReadDto;
import com.beeorg.mymarketing.entity.DashboardUser;
import com.beeorg.mymarketing.repository.entity.DashboardUserRepository;
import com.beeorg.mymarketing.service.builder.DashboardUserEntityBuilderService;
import com.beeorg.mymarketing.service.handler.CrudServiceHandler;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return CrudServiceHandler.save(
                user,
                dashboardUserEntityBuilderService::build,
                dashboardUserRepository::save,
                dashboardUserEntityBuilderService::reverse
        );
    }

    @Override
    public DashboardUserDto update(DashboardUserDto user) {
        return CrudServiceHandler.update(
                user,
                dashboardUserEntityBuilderService::update,
                dashboardUserRepository::save,
                dashboardUserEntityBuilderService::reverse
        );
    }

    @Override
    public List<DashboardUserDto> read() {
        return CrudServiceHandler.read(
                dashboardUserRepository::findAll,
                dashboardUserEntityBuilderService::reverse
        );
    }

    @Override
    public DashboardUserDto readDetail(DashboardUserReadDto user) {
        return CrudServiceHandler.readDetail(
                user.getId(),
                dashboardUserRepository::findById,
                DashboardUser::new,
                dashboardUserEntityBuilderService::reverse
        );
    }

    @Override
    public DashboardUserDto delete(DashboardUserReadDto user) {
        return CrudServiceHandler.delete (
                user.getId(),
                dashboardUserRepository::findById,
                DashboardUser::new,
                dashboardUserRepository::deleteById,
                dashboardUserEntityBuilderService::reverse
        );
    }
}
