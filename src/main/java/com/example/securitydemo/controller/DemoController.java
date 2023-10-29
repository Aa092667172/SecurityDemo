package com.example.securitydemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Kevin  on 2023/10/30
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {
  @GetMapping
  public ResponseEntity<String> hello(){
    return ResponseEntity.ok("你好");
  }
}
