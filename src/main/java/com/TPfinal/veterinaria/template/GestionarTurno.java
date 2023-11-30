package com.TPfinal.veterinaria.template;

import com.TPfinal.veterinaria.entidades.Turno;
import com.TPfinal.veterinaria.repositorios.TurnoRepositorio;

public class GestionarTurno extends TemplateTurno{
    @Override
    public void paso1(String animal, Long idMascota, Long idTurno, TurnoRepositorio turnoRepositorio) {
        System.out.println("tomar un turno");
        Turno turno = turnoRepositorio.findById(idTurno).orElse(null);
        turno.setMascotaID(idMascota);
        turno.setAnimal(animal);
        System.out.println("turno tomado");
    }

    @Override
    public void paso2() {
        System.out.println("atendiendose...");
        System.out.println("...");
        System.out.println("mascota curada!");
    }

    @Override
    public void paso3(Long idTurno, TurnoRepositorio turnoRepositorio) {
        System.out.println("se elimina el turno");
        turnoRepositorio.deleteById(idTurno);
    }
}
