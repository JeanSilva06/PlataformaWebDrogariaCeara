package com.drogaria.ceara.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    public LoginRequestDTO() {}

    public String getEmail() { return email; }
    public String getSenha() { return senha; }
}
