package com.TPfinal.veterinaria.repositorios;

import com.TPfinal.veterinaria.entidades.Perro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerroRepositorio extends JpaRepository<Perro, Long> {
}
