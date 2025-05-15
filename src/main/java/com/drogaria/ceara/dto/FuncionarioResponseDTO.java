package com.drogaria.ceara.dto;
import com.drogaria.ceara.model.Funcionario;

public class FuncionarioResponseDTO {
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String cargo;

    public FuncionarioResponseDTO(Long id, String nomeCompleto, String cpf, String email, String cargo) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
    }

    public Long getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getCargo() { return cargo; }

    public static FuncionarioResponseDTO fromEntity(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getNomeCompleto(),
            funcionario.getCpf(),
            funcionario.getEmail(),
            funcionario.getCargo()
        );
    }
}