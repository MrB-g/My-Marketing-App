package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.PointTierDto;
import com.beeorg.mymarketing.dto.RangeLimitDto;
import com.beeorg.mymarketing.entity.PointTier;
import com.beeorg.mymarketing.entity.RangeLimit;
import com.beeorg.mymarketing.repository.entity.PointTierRepository;
import com.beeorg.mymarketing.service.builder.RangeLimitEntityBuilderService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PointTierEntityBuilderService implements com.beeorg.mymarketing.service.builder.PointTierEntityBuilderService {

    private final RangeLimitService rangeLimitService;

    private final RangeLimitEntityBuilderService rangeLimitEntityBuilderService;

    private final PointTierRepository pointTierRepository;

    public PointTierEntityBuilderService(
            RangeLimitService rangeLimitService,
            RangeLimitEntityBuilderService rangeLimitEntityBuilderService,
            PointTierRepository pointTierRepository
    ) {
        this.rangeLimitService = rangeLimitService;
        this.rangeLimitEntityBuilderService = rangeLimitEntityBuilderService;
        this.pointTierRepository = pointTierRepository;
    }

    @Override
    public PointTier build(PointTierDto pointTier) {
        return PointTier.builder()
                .id(pointTier.getId())
                .name(pointTier.getName())
                .fromPoint(pointTier.getFromPoint())
                .fromPointLimit(getRangeLimitEntity(pointTier.getFromPointLimitId()))
                .toPoint(pointTier.getToPoint())
                .toPointLimit(getRangeLimitEntity(pointTier.getToPointLimitId()))
                .iconUrl(pointTier.getIconUrl())
                .createdAt(pointTier.getCreatedAt())
                .createdBy(pointTier.getCreatedBy())
                .updatedAt(pointTier.getUpdatedAt())
                .updatedBy(pointTier.getUpdatedBy())
                .build();
    }

    @Override
    public PointTierDto reverse(PointTier pointTier) {
        return PointTierDto.builder()
                .id(pointTier.getId())
                .name(pointTier.getName())
                .fromPoint(pointTier.getFromPoint())
                .fromPointLimitId(pointTier.getFromPointLimit().getId())
                .toPoint(pointTier.getToPoint())
                .toPointLimitId(pointTier.getToPointLimit().getId())
                .iconUrl(pointTier.getIconUrl())
                .createdAt(pointTier.getCreatedAt())
                .createdBy(pointTier.getCreatedBy())
                .updatedAt(pointTier.getUpdatedAt())
                .updatedBy(pointTier.getUpdatedBy())
                .build();
    }

    @Override
    public PointTier update(PointTierDto requestData) {
        PointTier dbData = pointTierRepository.findById(requestData.getId()).orElse(new PointTier());
        return dbData.toBuilder()
                .name(requestData.getName() != null ? requestData.getName() : dbData.getName())
                .fromPoint(requestData.getFromPoint() != null ? requestData.getFromPoint() : dbData.getFromPoint())
                .fromPointLimit(requestData.getFromPointLimitId() != null ? getRangeLimitEntity(requestData.getFromPointLimitId()) : dbData.getFromPointLimit())
                .toPoint(requestData.getToPoint() != null ? requestData.getToPoint() : dbData.getToPoint())
                .toPointLimit(requestData.getToPointLimitId() != null ? getRangeLimitEntity(requestData.getToPointLimitId()) : dbData.getToPointLimit())
                .iconUrl(requestData.getIconUrl() != null ? requestData.getIconUrl() : dbData.getIconUrl())
                .build();
    }

    private RangeLimit getRangeLimitEntity(int limitId) {
        Optional<RangeLimitDto> pointLimit = rangeLimitService.getRangeLimitById(limitId);
        return pointLimit.map(rangeLimitEntityBuilderService::build).orElse(null);
    }
}
