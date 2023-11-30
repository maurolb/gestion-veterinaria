package com.TPfinal.veterinaria.servicios;

import com.TPfinal.veterinaria.entidades.Gato;

import java.util.List;

public interface GatoServicioDAO {
    List<Gato> obtenerTodos();
    Gato obtenerPorID(Long id);
    Gato crear(Gato gato);
    Gato editarPorID(Long id, Gato gato);
    void eliminarPorID(Long id);
}
