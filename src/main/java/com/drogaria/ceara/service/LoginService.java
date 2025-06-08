package com.drogaria.ceara.service;

import com.drogaria.ceara.dto.LoginRequestDTO;
import com.drogaria.ceara.config.JwtUtil;
import com.drogaria.ceara.model.Funcionario;
import com.drogaria.ceara.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginService {

    private final FuncionarioRepository funcionarioRepository;
    private final JwtUtil jwtUtil;

    public LoginService(FuncionarioRepository funcionarioRepository, JwtUtil jwtUtil) {
        this.funcionarioRepository = funcionarioRepository;
        this.jwtUtil = jwtUtil;
    }

    public String autenticarUsuario(LoginRequestDTO loginDTO) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findByEmail(loginDTO.getEmail());

        if (funcionarioOpt.isEmpty() || !funcionarioOpt.get().getSenha().equals(loginDTO.getSenha())) {
            throw new RuntimeException("Email ou senha inválidos!");
        }

        return jwtUtil.gerarToken(loginDTO.getEmail());
    }
}