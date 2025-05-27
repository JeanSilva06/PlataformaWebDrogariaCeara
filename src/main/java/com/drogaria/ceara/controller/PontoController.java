package com.drogaria.ceara.controller;

import com.drogaria.ceara.dto.PontoRequestDTO;
import com.drogaria.ceara.dto.PontoResponseDTO;
import com.drogaria.ceara.service.PontoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ponto")
public class PontoController {

    private final PontoService pontoService;

    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @PostMapping
    public ResponseEntity<PontoResponseDTO> registrarPonto(@RequestBody PontoRequestDTO requestDTO) {
        PontoResponseDTO ponto = pontoService.registrarPonto(requestDTO);
        return ResponseEntity.ok(ponto);
    }

    @GetMapping
    public ResponseEntity<List<PontoResponseDTO>> listarPontos() {
        List<PontoResponseDTO> pontos = pontoService.listarPontos();
        return ResponseEntity.ok(pontos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoResponseDTO> buscarPorId(@PathVariable Long id) {
        PontoResponseDTO ponto = pontoService.buscarPorId(id);
        return ResponseEntity.ok(ponto);
    }
}
