package com.TPfinal.veterinaria.repositorios;

import com.TPfinal.veterinaria.entidades.Gato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatoRepositorio extends JpaRepository<Gato, Long> {
}
