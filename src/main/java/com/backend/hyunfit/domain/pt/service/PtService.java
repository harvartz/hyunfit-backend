package com.backend.hyunfit.domain.pt.service;

import com.backend.hyunfit.domain.pt.dto.PtDTO;

public interface PtService {
    int createPt(PtDTO ptDTO);

    void modifyPt(PtDTO ptDTO);
}
