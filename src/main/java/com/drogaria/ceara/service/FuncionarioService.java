package com.drogaria.ceara.service;

import com.drogaria.ceara.model.Funcionario;
import com.drogaria.ceara.dto.FuncionarioRequestDTO;
import com.drogaria.ceara.dto.FuncionarioResponseDTO;
import com.drogaria.ceara.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public FuncionarioResponseDTO cadastrarFuncionario(FuncionarioRequestDTO requestDTO) {
        Funcionario funcionario = new Funcionario(
                requestDTO.getNomeCompleto(),
                requestDTO.getCpf(),
                requestDTO.getEmail(),
                requestDTO.getSenha(), // Senha ainda pode ser enviada na criação
                requestDTO.getCargo());

        Funcionario novoFuncionario = funcionarioRepository.save(funcionario);
        return FuncionarioResponseDTO.fromEntity(novoFuncionario);
    }

    public List<FuncionarioResponseDTO> listarFuncionarios() {
        return funcionarioRepository.findAll().stream()
                .map(FuncionarioResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public FuncionarioResponseDTO buscarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));

        return FuncionarioResponseDTO.fromEntity(funcionario);
    }

    public FuncionarioResponseDTO atualizarFuncionario(Long id, FuncionarioRequestDTO requestDTO) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));

        funcionario.setNomeCompleto(requestDTO.getNomeCompleto());
        funcionario.setCpf(requestDTO.getCpf());
        funcionario.setEmail(requestDTO.getEmail());
        funcionario.setSenha(requestDTO.getSenha()); // Se necessário atualizar a senha
        funcionario.setCargo(requestDTO.getCargo());

        Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);
        return FuncionarioResponseDTO.fromEntity(funcionarioAtualizado);
    }

    public void excluirFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));

        funcionarioRepository.delete(funcionario);
    }
}