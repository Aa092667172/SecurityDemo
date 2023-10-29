package com.example.securitydemo.service;

import com.example.securitydemo.dto.AuthRequest;
import com.example.securitydemo.dto.AuthResponse;
import com.example.securitydemo.dto.RegisterRequest;
import com.example.securitydemo.entity.User;
import com.example.securitydemo.mapper.RegisterMapper;
import com.example.securitydemo.repository.UserRepository;
import com.example.securitydemo.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author Kevin  on 2023/10/30
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository userRepository;
  private final RegisterMapper registerMapper;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthResponse register(RegisterRequest registerRequest) {
    User entity = registerMapper.toEntity(registerRequest);
    entity.setRole(Role.USER);
    String encode = passwordEncoder.encode(registerRequest.password());
    entity.setPassword(encode);
    userRepository.save(entity);
    var jwtToken = jwtService.generateToken(entity);
    return new AuthResponse(jwtToken);
  }


  public AuthResponse authenticate(AuthRequest authRequest) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.password())
    );
    var user = userRepository.findByEmail(authRequest.email()).orElseThrow();
    String jwtToken = jwtService.generateToken(user);
    return new AuthResponse(jwtToken);
  }
}
