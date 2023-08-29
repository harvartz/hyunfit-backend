package com.backend.hyunfit.domain.auth.mapper;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AuthMapper {
    Optional<AuthDTO> findMemberAuth(AuthDTO authDTO);
}
