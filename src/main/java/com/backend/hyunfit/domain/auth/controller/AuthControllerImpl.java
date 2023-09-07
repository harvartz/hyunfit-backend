package com.backend.hyunfit.domain.auth.controller;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.domain.auth.service.AuthService;
import com.backend.hyunfit.global.security.provider.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;
    private final JwtProvider jwtProvider;
    @PostMapping("/member")
    public ResponseEntity<AuthDTO> createMemberAuth(@RequestBody AuthDTO authDTO) {
        AuthDTO authResponse = authService.createMemberAuth(authDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.setAuthenticated(authResponse.isAuthenticated());
        authResponse.setRole("member");
        String token = jwtProvider.createToken(authentication,authResponse);
        System.out.println("token : " + token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        return new ResponseEntity<>(authResponse, headers, HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<AuthDTO> createAdminAuth(@RequestBody AuthDTO authDTO) {
        AuthDTO authResponse = authService.createAdminAuth(authDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.setAuthenticated(authResponse.isAuthenticated());
        authResponse.setRole("admin");
        String token = jwtProvider.createToken(authentication,authResponse);
        System.out.println("token : " + token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        return ResponseEntity.ok(authResponse);
    }
  
    @PostMapping("/trainer")
    public ResponseEntity<AuthDTO> createTrainerAuth(@RequestBody AuthDTO authDTO) {
        AuthDTO authResponse = authService.createTrainerAuth(authDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.setAuthenticated(authResponse.isAuthenticated());
        authResponse.setRole("trainer");
        String token = jwtProvider.createToken(authentication,authResponse);
        System.out.println("token : " + token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        return ResponseEntity.ok(authResponse);
    }

}