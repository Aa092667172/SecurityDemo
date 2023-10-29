package com.example.securitydemo.controller;

import com.example.securitydemo.dto.AuthRequest;
import com.example.securitydemo.dto.RegisterRequest;
import com.example.securitydemo.dto.AuthResponse;
import com.example.securitydemo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Kevin  on 2023/10/30
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
    return ResponseEntity.ok(authenticationService.register(registerRequest));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest){
    return ResponseEntity.ok(authenticationService.authenticate(authRequest));
  }


}
