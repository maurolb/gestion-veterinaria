package com.TPfinal.veterinaria.template;

import com.TPfinal.veterinaria.entidades.Mascota;
import com.TPfinal.veterinaria.entidades.Turno;
import com.TPfinal.veterinaria.repositorios.TurnoRepositorio;

public abstract class TemplateTurno {
    public abstract void paso1(String animal, Long idMascota, Long idTurno, TurnoRepositorio turnoRepositorio);
    public abstract void paso2();
    public abstract void paso3(Long idTurno, TurnoRepositorio turnoRepositorio);

    public final void gestionar(String animal, Long idMascota, Long idTurno, TurnoRepositorio turnoRepositorio){
        paso1(animal, idMascota, idTurno, turnoRepositorio);
        paso2();
        paso3(idTurno, turnoRepositorio);
    }
}
