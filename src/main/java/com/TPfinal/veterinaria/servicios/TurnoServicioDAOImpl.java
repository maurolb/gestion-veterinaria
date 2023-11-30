package com.TPfinal.veterinaria.servicios;

import com.TPfinal.veterinaria.entidades.Medico;
import com.TPfinal.veterinaria.entidades.Turno;
import com.TPfinal.veterinaria.repositorios.GatoRepositorio;
import com.TPfinal.veterinaria.repositorios.MedicoRepositorio;
import com.TPfinal.veterinaria.repositorios.PerroRepositorio;
import com.TPfinal.veterinaria.repositorios.TurnoRepositorio;
import com.TPfinal.veterinaria.template.GestionarTurno;
import com.TPfinal.veterinaria.template.TemplateTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServicioDAOImpl implements TurnoServicioDAO {
    @Autowired
    private final TurnoRepositorio turnoRepositorio;
    @Autowired
    private final MedicoRepositorio medicoRepositorio;
    @Autowired
    private final PerroRepositorio perroRepositorio;
    @Autowired
    private final GatoRepositorio gatoRepositorio;

    public TurnoServicioDAOImpl(TurnoRepositorio turnoRepositorio, MedicoRepositorio medicoRepositorio, PerroRepositorio perroRepositorio, GatoRepositorio gatoRepositorio) {
        this.turnoRepositorio = turnoRepositorio;
        this.medicoRepositorio = medicoRepositorio;
        this.perroRepositorio = perroRepositorio;
        this.gatoRepositorio = gatoRepositorio;
    }


    @Override
    public List<Turno> obtenerTodos() {
        return turnoRepositorio.findAll();
    }

    @Override
    public List<Turno> obtenerPorIDMedico(Long idMedico) {
        Medico medicoEncontrado = medicoRepositorio.findById(idMedico).orElse(null);
        if(medicoEncontrado != null){
            List<Turno> turnosPorMedico = medicoEncontrado.getTurnos();
            return turnosPorMedico;
        }
        return null;
    }

    @Override
    public String gestionarTurno(String animal, Long idMascota, Long idTurno) {

        TemplateTurno templateTurno = new GestionarTurno();
        templateTurno.gestionar(animal, idMascota, idTurno, turnoRepositorio);

        return "Turno gestionado";
    }

    @Override
    public Turno obtenerPorID(Long id) {
        return turnoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Turno crear(Long idMedico, Turno turno) {
        Medico medico = medicoRepositorio.findById(idMedico).orElse(null);
        if(medico != null){
            turno.setMedico(medico);
        }
        return turnoRepositorio.save(turno);
    }

    @Override
    public void eliminarPorID(Long id) {
        turnoRepositorio.deleteById(id);
    }
}
