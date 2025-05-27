package com.drogaria.ceara.model;

import java.time.LocalDateTime;

import com.drogaria.ceara.enums.TipoPonto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ponto")
public class Ponto {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private TipoPonto tipo; //ponto de Entrada ou Saida

    //Construtor vazio
    public Ponto() {}

    //Construtor com parâmetros
    public Ponto(Funcionario funcionario, LocalDateTime dataHora, TipoPonto tipo) {
        this.funcionario = funcionario;
        this.dataHora = dataHora;
        this.tipo = tipo;
    }

    //Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public TipoPonto getTipoPonto() { return tipo; }
    public void setTipoPonto(TipoPonto tipo) { this.tipo = tipo; }
}
