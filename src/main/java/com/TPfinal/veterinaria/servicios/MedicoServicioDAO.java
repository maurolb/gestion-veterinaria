package com.TPfinal.veterinaria.servicios;

import com.TPfinal.veterinaria.entidades.Medico;

import java.util.List;

public interface MedicoServicioDAO {
    List<Medico> obtenerTodos();
    Medico obtenerPorID(Long id);
    Medico crear(Medico medico);
    Medico editarPorID(Long id, Medico medico);
    void eliminarPorID(Long id);
}
