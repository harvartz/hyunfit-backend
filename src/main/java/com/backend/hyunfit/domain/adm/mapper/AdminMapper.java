package com.backend.hyunfit.domain.adm.mapper;

import com.backend.hyunfit.domain.adm.dto.AdminDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AdminMapper {
    Optional<AdminDTO> selectOneAdminByAdmId(String admId);
}
