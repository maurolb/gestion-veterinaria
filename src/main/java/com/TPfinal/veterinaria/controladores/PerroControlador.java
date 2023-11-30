package com.TPfinal.veterinaria.controladores;

import com.TPfinal.veterinaria.entidades.Perro;
import com.TPfinal.veterinaria.servicios.PerroServicioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perros")
public class PerroControlador {
    @Autowired
    private final PerroServicioDAO perroServicioDAO;

    public PerroControlador(PerroServicioDAO perroServicioDAO) {
        this.perroServicioDAO = perroServicioDAO;
    }

    @GetMapping()
    public ResponseEntity<List<Perro>> obtenerListaPerros() throws Exception {
        try {
            return ResponseEntity.ok(perroServicioDAO.obtenerTodos());
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perro> obtenerPerroPorID(@PathVariable Long id) throws Exception {
        try {
          return ResponseEntity.ok(perroServicioDAO.obtenerPorID(id));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @PostMapping()
    public ResponseEntity<Perro> crearPerro(@RequestBody Perro perro) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(perroServicioDAO.crear(perro));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perro> editarPerroPorID(@PathVariable Long id, @RequestBody Perro perro) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(perroServicioDAO.editarPorID(id, perro));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarPerroPorID(@PathVariable Long id) throws Exception {
        try {
            perroServicioDAO.eliminarPorID(id);
            return ResponseEntity.ok().body(true);
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }
}
