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
    public PtDTO createPt(PtDTO ptDTO) {

        return ptMapper.insertOnePt(ptDTO);
    }
}
