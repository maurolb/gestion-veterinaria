package com.TPfinal.veterinaria.servicios;

import com.TPfinal.veterinaria.entidades.Turno;

import java.util.List;

public interface TurnoServicioDAO {
    List<Turno> obtenerTodos();
    List<Turno> obtenerPorIDMedico(Long idMedico);
    String gestionarTurno(String animal, Long idMascota, Long idTurno);
    Turno obtenerPorID(Long id);
    Turno crear(Long idMedico, Turno turno);
    void eliminarPorID(Long id);
}
