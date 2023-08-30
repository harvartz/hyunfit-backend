package com.backend.hyunfit.domain.pt.service;

import com.backend.hyunfit.domain.pt.dto.PtDTO;
import com.backend.hyunfit.domain.pt.mapper.PtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PtServiceImpl implements PtService{

    private final PtMapper ptMapper;
    @Override
    public int createPt(PtDTO ptDTO) {
        // validation 처리
        return ptMapper.insertOnePt(ptDTO);
    }
}
