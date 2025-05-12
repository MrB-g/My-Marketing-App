package com.beeorg.mymarketing.service;

import com.beeorg.mymarketing.dto.RangeLimitDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RangeLimitService {

    List<RangeLimitDto> getFromRangeLimitList();

    boolean isFromValidity(int id);

    List<RangeLimitDto> getToRangeLimitList();
}
