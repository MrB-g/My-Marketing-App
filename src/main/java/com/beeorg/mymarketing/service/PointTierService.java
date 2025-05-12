package com.beeorg.mymarketing.service;

import com.beeorg.mymarketing.dto.PointTierDto;
import com.beeorg.mymarketing.dto.PointTierReadDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PointTierService {

    PointTierDto create(PointTierDto pointTier);

    PointTierDto update(PointTierDto pointTier);

    List<PointTierDto> read();

    PointTierDto readDetail(PointTierReadDto pointTier);

    PointTierDto delete(PointTierReadDto pointTier);
}
