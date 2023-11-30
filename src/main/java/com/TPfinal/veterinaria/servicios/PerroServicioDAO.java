package com.TPfinal.veterinaria.servicios;

import com.TPfinal.veterinaria.entidades.Perro;

import java.util.List;

public interface PerroServicioDAO {
    List<Perro> obtenerTodos();
    Perro obtenerPorID(Long id);
    Perro crear(Perro perro);
    Perro editarPorID(Long id, Perro perro);
    void eliminarPorID(Long id);
}
