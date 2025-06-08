package com.drogaria.ceara.controller;

import com.drogaria.ceara.dto.LoginRequestDTO;
import com.drogaria.ceara.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> realizarLogin(@RequestBody LoginRequestDTO loginDTO) {
        String token = loginService.autenticarUsuario(loginDTO);
        return ResponseEntity.ok(Map.of("token", token));
    }
}