package com.TPfinal.veterinaria.servicios;

import com.TPfinal.veterinaria.entidades.Gato;
import com.TPfinal.veterinaria.repositorios.GatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatoServicioDAOImpl implements GatoServicioDAO{
    @Autowired
    private final GatoRepositorio gatoRepositorio;

    public GatoServicioDAOImpl(GatoRepositorio gatoRepositorio) {
        this.gatoRepositorio = gatoRepositorio;
    }

    @Override
    public List<Gato> obtenerTodos() {
        return gatoRepositorio.findAll();
    }

    @Override
    public Gato obtenerPorID(Long id) {
        return gatoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Gato crear(Gato gato) {
        return gatoRepositorio.save(gato);
    }

    @Override
    public Gato editarPorID(Long id, Gato gato) {
        Gato gatoParaEditar = gatoRepositorio.findById(id).orElse(null);
        if(gatoParaEditar != null){
            gatoParaEditar.setEdad(gato.getEdad());
            gatoParaEditar.setRaza(gato.getRaza());
            gatoParaEditar.setNombre(gato.getNombre());
            gatoParaEditar.setSexo(gato.getSexo());
            gatoParaEditar.setEscupePelo(gato.isEscupePelo());
            gatoParaEditar.setPeleaEnElTecho(gato.isPeleaEnElTecho());
        }
        return gatoRepositorio.save(gatoParaEditar);
    }

    @Override
    public void eliminarPorID(Long id) {
        gatoRepositorio.deleteById(id);
    }
}
