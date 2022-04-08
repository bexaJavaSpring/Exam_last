package com.example.exam_last.controller;

import com.example.exam_last.dto.LoginDto;
import com.example.exam_last.security.JwtProvider;
import com.example.exam_last.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    final AuthenticationManager authenticationManager;
    final AuthService authService;
    final JwtProvider jwtProvider;

    @PostMapping("login")
    public HttpEntity<?> login(@RequestBody LoginDto dto){
        String token = jwtProvider.generateToken(dto.getUsername());
        return ResponseEntity.ok().body(token);
    }

}
