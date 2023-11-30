package com.TPfinal.veterinaria.repositorios;

import com.TPfinal.veterinaria.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositorio extends JpaRepository<Medico, Long> {
}
