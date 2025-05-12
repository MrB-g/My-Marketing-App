package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.PointTierDto;
import com.beeorg.mymarketing.dto.PointTierReadDto;
import com.beeorg.mymarketing.entity.PointTier;
import com.beeorg.mymarketing.repository.entity.PointTierRepository;
import com.beeorg.mymarketing.service.builder.PointTierEntityBuilderService;
import com.beeorg.mymarketing.service.handler.CrudServiceHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointTierService implements com.beeorg.mymarketing.service.PointTierService {

    private final PointTierRepository pointTierRepository;

    private final PointTierEntityBuilderService pointTierEntityBuilderService;

    public PointTierService(PointTierRepository pointTierRepository, PointTierEntityBuilderService pointTierEntityBuilderService) {
        this.pointTierRepository = pointTierRepository;
        this.pointTierEntityBuilderService = pointTierEntityBuilderService;
    }

    @Override
    public PointTierDto create(PointTierDto pointTier) {
        return CrudServiceHandler.save(
                pointTier,
                pointTierEntityBuilderService::build,
                pointTierRepository::save,
                pointTierEntityBuilderService::reverse
        );
    }

    @Override
    public PointTierDto update(PointTierDto pointTier) {
        return CrudServiceHandler.update(
                pointTier,
                pointTierEntityBuilderService::update,
                pointTierRepository::save,
                pointTierEntityBuilderService::reverse
        );
    }

    @Override
    public List<PointTierDto> read() {
        return CrudServiceHandler.read(
                pointTierRepository::findAll,
                pointTierEntityBuilderService::reverse
        );
    }

    @Override
    public PointTierDto readDetail(PointTierReadDto pointTier) {
        return CrudServiceHandler.readDetail(
                pointTier.getId(),
                pointTierRepository::findById,
                PointTier::new,
                pointTierEntityBuilderService::reverse
        );
    }

    @Override
    public PointTierDto delete(PointTierReadDto pointTier) {
        return CrudServiceHandler.delete(
                pointTier.getId(),
                pointTierRepository::findById,
                PointTier::new,
                pointTierRepository::deleteById,
                pointTierEntityBuilderService::reverse
        );
    }
}
