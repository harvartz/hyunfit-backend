package com.backend.hyunfit.domain.adm.service;

import com.backend.hyunfit.domain.adm.dto.AdminDTO;
import com.backend.hyunfit.domain.adm.mapper.AdminMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final AdminMapper adminMapper;

    public AdminDTO selectOneAdminByAdmId(String admId) {
        AdminDTO adminDTO = adminMapper.selectOneAdminByAdmId(admId)
                .orElseThrow(BusinessException.supplierOf(ErrorCode.USERID_NOT_FOUND));
        adminDTO.setAdmPw(null);
        return adminDTO;
    }

}
