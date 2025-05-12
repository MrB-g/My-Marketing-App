package com.beeorg.mymarketing.service.builder;

import com.beeorg.mymarketing.dto.PointTierDto;
import com.beeorg.mymarketing.entity.PointTier;
import org.springframework.stereotype.Service;

@Service
public interface PointTierEntityBuilderService extends BaseBuilderService<PointTier, PointTierDto>, UpdateBuilderService<PointTier, PointTierDto> {
}
