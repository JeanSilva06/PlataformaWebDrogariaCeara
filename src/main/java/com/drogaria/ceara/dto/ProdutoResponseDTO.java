package com.drogaria.ceara.dto;

import java.time.LocalDate;

import com.drogaria.ceara.model.Produto;

public class ProdutoResponseDTO {

    //Atributos
    private final long id;
    private final String nome;
    private final String categoria;
    private final int quantidade;
    private final double preco;
    private final LocalDate validade;

    //Construtor com parâmetros
    public ProdutoResponseDTO(long id, String nome, String categoria, int quantidade, double preco, LocalDate validade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
        this.validade = validade;
    }

    //Convertendo Produto recebido para ResponseDTO
    public static ProdutoResponseDTO fromEntity(Produto produto) {
        return new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getCategoria(),
                produto.getQuantidade(), produto.getPreco(), produto.getValidade());
    }

    //Getters (para tornar a resposta imutável/impossível de alterar)
    public long getId() { return id; }

    public String getNome() { return nome; }

    public String getCategoria() { return categoria; }

    public int getQuantidade() { return quantidade; }

    public double getPreco() { return preco; }

    public LocalDate getValidade() { return validade; }
}
