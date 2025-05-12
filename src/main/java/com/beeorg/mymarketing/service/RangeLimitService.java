package com.beeorg.mymarketing.service;

import com.beeorg.mymarketing.dto.RangeLimitDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RangeLimitService {

    List<RangeLimitDto> getFromRangeLimitList();

    boolean isFromValidity(int id);

    Optional<RangeLimitDto> getRangeLimitById(int id);

    List<RangeLimitDto> getToRangeLimitList();
}
