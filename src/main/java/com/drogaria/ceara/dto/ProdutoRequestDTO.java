package com.drogaria.ceara.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdutoRequestDTO {

    //Validação de atributos recebidos
    @NotBlank(message = "O nome nao pode estar vazio")
    private String nome;
    
    @NotBlank(message = "A categoria nao pode estar vazia")
    private String categoria;
    
    @Positive(message = "A quantidade deve ser maior que zero")
    private int quantidade;
    
    @Positive(message = "O preço não pode ser negativo")
    private double preco;
    
    private LocalDate validade;

    //Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public LocalDate getValidade() { return validade; }
    public void setValidade(LocalDate validade) { this.validade = validade; }
}
