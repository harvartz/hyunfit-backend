package com.backend.hyunfit.domain.adm.controller;

import com.backend.hyunfit.domain.adm.dto.AdminDTO;
import com.backend.hyunfit.domain.adm.service.AdminService;
import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import com.backend.hyunfit.global.security.provider.JwtProvider;

@CrossOrigin(origins = "${vue.url}")
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admins")
public class AdminControllerImpl implements AdminController{
    private final AdminService adminService;
    private final JwtProvider jwtProvider;

    @GetMapping("/me")
    public AdminDTO selectOneTrainerByToken(@RequestHeader("authorization") String authorizationHeader){
        AuthDTO authDTO = jwtProvider.getUserInfo(authorizationHeader);
        return adminService.selectOneAdminByAdmId(authDTO.getUsername());
    }
}
