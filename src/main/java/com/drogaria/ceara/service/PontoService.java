package com.drogaria.ceara.service;

import com.drogaria.ceara.dto.PontoRequestDTO;
import com.drogaria.ceara.dto.PontoResponseDTO;
import com.drogaria.ceara.exception.FuncionarioNaoEncontradoException;
import com.drogaria.ceara.model.Funcionario;
import com.drogaria.ceara.model.Ponto;
import com.drogaria.ceara.enums.TipoPonto;
import com.drogaria.ceara.repository.FuncionarioRepository;
import com.drogaria.ceara.repository.PontoRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontoService {

    private final PontoRepository pontoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public PontoService(PontoRepository pontoRepository, FuncionarioRepository funcionarioRepository) {
        this.pontoRepository = pontoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public PontoResponseDTO registrarPonto(PontoRequestDTO requestDTO) {
        Funcionario funcionario = funcionarioRepository.findById(requestDTO.getFuncionarioId())
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário não encontrado!"));

        Ponto novoPonto = new Ponto(funcionario, LocalDateTime.now(), TipoPonto.valueOf(requestDTO.getTipo()));
        Ponto pontoSalvo = pontoRepository.save(novoPonto);

        return PontoResponseDTO.fromEntity(pontoSalvo);
    }

    public List<PontoResponseDTO> listarPontos() {
        return pontoRepository.findAll().stream()
                .map(PontoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public PontoResponseDTO buscarPorId(Long id) {
        Ponto ponto = pontoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de ponto não encontrado!"));
        return PontoResponseDTO.fromEntity(ponto);
    }
}
