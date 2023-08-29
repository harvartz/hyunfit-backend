package com.backend.hyunfit.domain.auth.mapper;

import com.backend.hyunfit.domain.auth.dto.AuthVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AuthMapper {
    Optional<AuthVO> findMemberAuth(AuthVO authVO);
}
