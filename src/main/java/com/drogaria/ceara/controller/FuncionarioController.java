package com.drogaria.ceara.controller;

import com.drogaria.ceara.dto.FuncionarioRequestDTO;
import com.drogaria.ceara.dto.FuncionarioResponseDTO;
import com.drogaria.ceara.service.FuncionarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public FuncionarioResponseDTO cadastrarFuncionario(@Valid @RequestBody FuncionarioRequestDTO requestDTO) {
        return funcionarioService.cadastrarFuncionario(requestDTO);
    }

    @GetMapping
    public List<FuncionarioResponseDTO> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public FuncionarioResponseDTO buscarFuncionarioPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public FuncionarioResponseDTO atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioRequestDTO requestDTO) {
        return funcionarioService.atualizarFuncionario(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void excluirFuncionario(@PathVariable Long id) {
        funcionarioService.excluirFuncionario(id);
    }
}