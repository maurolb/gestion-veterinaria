package com.TPfinal.veterinaria.controladores;

import com.TPfinal.veterinaria.entidades.Medico;
import com.TPfinal.veterinaria.servicios.MedicoServicioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoControlador {
    @Autowired
    private final MedicoServicioDAO medicoServicioDAO;

    public MedicoControlador(MedicoServicioDAO medicoServicioDAO) {
        this.medicoServicioDAO = medicoServicioDAO;
    }

    @GetMapping()
    public ResponseEntity<List<Medico>> obtenerListaMedicos() throws Exception {
        try {
            return ResponseEntity.ok(medicoServicioDAO.obtenerTodos());
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerMedicoPorID(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(medicoServicioDAO.obtenerPorID(id));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @PostMapping()
    public ResponseEntity<Medico> crearMedico(@RequestBody Medico medico) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(medicoServicioDAO.crear(medico));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> editarMedicoPorID(@PathVariable Long id, @RequestBody Medico medico) throws Exception {
        try {
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(medicoServicioDAO.editarPorID(id, medico));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarMedicoPorID(@PathVariable Long id) throws Exception {
        try {
            medicoServicioDAO.eliminarPorID(id);
            return ResponseEntity.ok(true);
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }
}
