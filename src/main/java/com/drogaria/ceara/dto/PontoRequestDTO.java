package com.drogaria.ceara.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PontoRequestDTO {

    //Atributos
    @NotNull(message = "O ID do funcionario nao pode ser nulo")
    private Long funcionarioId;

    @Pattern(regexp = "ENTRADA|SAIDA", message = "O tipo deve ser ENTRADA ou SAIDA")
    private String tipo;

    //Construtor vazio
    public PontoRequestDTO() {}

    //Getters e Setters
    public Long getFuncionarioId() { return funcionarioId; }
    public String getTipo() { return tipo; }

    public void setFuncionarioId(Long funcionarioId) { this.funcionarioId = funcionarioId; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
