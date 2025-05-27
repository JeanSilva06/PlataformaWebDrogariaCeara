package com.drogaria.ceara.exception;

public class FuncionarioNaoEncontradoException extends RuntimeException {
    public FuncionarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
