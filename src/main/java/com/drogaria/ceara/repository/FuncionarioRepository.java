package com.drogaria.ceara.repository;

import com.drogaria.ceara.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}