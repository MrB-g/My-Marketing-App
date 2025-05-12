package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.RangeLimitDto;
import com.beeorg.mymarketing.entity.RangeLimit;
import com.beeorg.mymarketing.repository.entity.RangeLimitRepository;
import com.beeorg.mymarketing.service.builder.RangeLimitEntityBuilderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RangeLimitService implements com.beeorg.mymarketing.service.RangeLimitService {

    private final RangeLimitRepository rangeLimitRepository;

    private final RangeLimitEntityBuilderService rangeLimitEntityBuilderService;

    public RangeLimitService(
            RangeLimitRepository rangeLimitRepository,
            RangeLimitEntityBuilderService rangeLimitEntityBuilderService
    ) {
        this.rangeLimitRepository = rangeLimitRepository;
        this.rangeLimitEntityBuilderService = rangeLimitEntityBuilderService;
    }

    @Override
    public List<RangeLimitDto> getFromRangeLimitList() {
        List<RangeLimit> fromRangeLimitListEntity = rangeLimitRepository.findByValidity("FROM");
        return fromRangeLimitListEntity.stream().map(rangeLimitEntityBuilderService::reverse).toList();
    }

    @Override
    public boolean isFromValidity(int id) {
        RangeLimit fromRangeLimitEntity = rangeLimitRepository.findById(id).orElse(null);
        if (fromRangeLimitEntity == null) {
            return false;
        }
        return fromRangeLimitEntity.getValidity().equals("FROM");
    }

    @Override
    public List<RangeLimitDto> getToRangeLimitList() {
        List<RangeLimit> toRangeLimitListEntity = rangeLimitRepository.findByValidity("TO");
        return toRangeLimitListEntity.stream().map(rangeLimitEntityBuilderService::reverse).toList();
    }
}
