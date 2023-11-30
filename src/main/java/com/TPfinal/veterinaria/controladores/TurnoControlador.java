package com.TPfinal.veterinaria.controladores;

import com.TPfinal.veterinaria.entidades.Turno;
import com.TPfinal.veterinaria.servicios.TurnoServicioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoControlador {
    @Autowired
    private final TurnoServicioDAO turnoServicioDAO;

    public TurnoControlador(TurnoServicioDAO turnoServicioDAO) {
        this.turnoServicioDAO = turnoServicioDAO;
    }

    @GetMapping()
    public ResponseEntity<List<Turno>> obtenerListaTurnos() throws Exception {
        try {
            return ResponseEntity.ok(turnoServicioDAO.obtenerTodos());
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> obtnerTurnoPorID(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(turnoServicioDAO.obtenerPorID(id));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @GetMapping("/medico/{idMedico}")
    public ResponseEntity<List<Turno>> obtnerTurnosPorIDMedico(@PathVariable Long idMedico) throws Exception {
        try {
            return ResponseEntity.ok(turnoServicioDAO.obtenerPorIDMedico(idMedico));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @PostMapping("/{idMedico}")
    public ResponseEntity<Turno> crearTurno(@PathVariable Long idMedico, @RequestBody Turno turno) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(turnoServicioDAO.crear(idMedico, turno));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @PutMapping("/{animal}/{idMascota}/{idTurno}")
    public ResponseEntity<String> gestionarTurno(@PathVariable() String animal, @PathVariable() Long idMascota, @PathVariable Long idTurno) throws Exception {
        try {
         return ResponseEntity.ok(turnoServicioDAO.gestionarTurno(animal, idMascota, idTurno));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarTurnoPorID(@PathVariable Long id) throws Exception {
        try {
            turnoServicioDAO.eliminarPorID(id);
            return ResponseEntity.ok(true);
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }
}
