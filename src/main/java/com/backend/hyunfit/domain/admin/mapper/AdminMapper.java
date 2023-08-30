package com.backend.hyunfit.domain.admin.mapper;

import com.backend.hyunfit.domain.admin.dto.AdminDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AdminMapper {
    Optional<AdminDTO> selectOneAdminByAdmId(String admId);
}
