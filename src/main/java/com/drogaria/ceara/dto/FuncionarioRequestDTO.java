package com.drogaria.ceara.dto;

public class FuncionarioRequestDTO {
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String senha;
    private String cargo;

    public FuncionarioRequestDTO() {}

    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getCargo() { return cargo; }
}