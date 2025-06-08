package com.drogaria.ceara.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

public class JwtFiltroAutenticacao extends GenericFilterBean {

    private final JwtUtil jwtUtil;

    public JwtFiltroAutenticacao(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization");

        if (token != null && jwtUtil.validarToken(token.replace("Bearer ", ""))) {
            chain.doFilter(request, response);
        } else {
            throw new RuntimeException("Acesso negado!");
        }
    }
}