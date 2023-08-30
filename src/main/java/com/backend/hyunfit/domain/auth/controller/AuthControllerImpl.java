package com.backend.hyunfit.domain.auth.controller;


import com.backend.hyunfit.domain.auth.dto.AuthDTO;
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
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;

    @PostMapping("/member")
    public ResponseEntity<AuthDTO> createMemberAuth(@RequestBody AuthDTO authDTO) {
        AuthDTO authResponse = authService.createMemberAuth(authDTO);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/admin")
    public ResponseEntity<AuthDTO> createAdminAuth(@RequestBody AuthDTO authDTO) {
        AuthDTO authResponse = authService.createAdminAuth(authDTO);
        return ResponseEntity.ok(authResponse);
    }
  
    @PostMapping("/trainer")
    public ResponseEntity<AuthDTO> createTrainerAuth(@RequestBody AuthDTO authDTO) {
        AuthDTO authResponse = authService.createTrainerAuth(authDTO);
        return ResponseEntity.ok(authResponse);
    }
}