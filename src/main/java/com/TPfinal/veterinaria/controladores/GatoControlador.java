package com.TPfinal.veterinaria.controladores;

import com.TPfinal.veterinaria.entidades.Gato;
import com.TPfinal.veterinaria.servicios.GatoServicioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatos")
public class GatoControlador {
    @Autowired
    private final GatoServicioDAO gatoServicioDAO;

    public GatoControlador(GatoServicioDAO gatoServicioDAO) {
        this.gatoServicioDAO = gatoServicioDAO;
    }

    @GetMapping()
    public ResponseEntity<List<Gato>> obtenerListaGatos() throws Exception {
        try {
            return ResponseEntity.ok(gatoServicioDAO.obtenerTodos());
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gato> obtenerGatoPorID(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(gatoServicioDAO.obtenerPorID(id));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @PostMapping()
    public ResponseEntity<Gato> crearGato(@RequestBody Gato gato) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(gatoServicioDAO.crear(gato));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gato> editarGatoPorID(@PathVariable Long id, @RequestBody Gato gato) throws  Exception {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(gatoServicioDAO.editarPorID(id, gato));
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarGatoPorID(@PathVariable Long id) throws Exception {
        try {
          gatoServicioDAO.eliminarPorID(id);
          return ResponseEntity.ok(true);
        } catch (Exception e){
            throw new Exception("Ocurrio un error: ", e);
        }
    }
}
