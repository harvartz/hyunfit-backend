package com.backend.hyunfit.domain.auth.controller;


import com.backend.hyunfit.domain.auth.dto.AuthVO;
import com.backend.hyunfit.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("member")
    public ResponseEntity<AuthVO> createMemberAuth(@RequestBody AuthVO authVO) {
        AuthVO authResponse = authService.createMemberAuth(authVO);
        return ResponseEntity.ok(authResponse);
    }
}
