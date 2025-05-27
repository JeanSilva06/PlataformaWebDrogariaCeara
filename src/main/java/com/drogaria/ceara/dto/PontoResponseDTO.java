package com.drogaria.ceara.dto;

import java.time.LocalDateTime;

import com.drogaria.ceara.enums.TipoPonto;
import com.drogaria.ceara.model.Ponto;

public class PontoResponseDTO {
    //Atributos
    private final Long id;
    private final String nomeFuncionario;
    private final LocalDateTime dataHora;
    private final TipoPonto tipo;

    //Construtor com parâmetros
    public PontoResponseDTO(Long id, String nomeFuncionario, LocalDateTime dataHora, TipoPonto tipo) {
        this.id = id;
        this.nomeFuncionario = nomeFuncionario;
        this.dataHora = dataHora;
        this.tipo = tipo;
    }

    //Getters (para tornar a resposta imutável/impossível de alterar)
    public Long getId() { return id; }

    public String getNomeFuncionario() { return nomeFuncionario; }

    public LocalDateTime getDataHora() { return dataHora; }

    public TipoPonto getTipo() { return tipo; }

    //Resposta devolvida a partir dos atributos de Ponto
    public static PontoResponseDTO fromEntity(Ponto ponto) {
        return new PontoResponseDTO(
                ponto.getId(),
                ponto.getFuncionario().getNomeCompleto(),
                ponto.getDataHora(),
                ponto.getTipoPonto()
        );
    }
}
