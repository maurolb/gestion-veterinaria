package com.TPfinal.veterinaria.servicios;

import com.TPfinal.veterinaria.entidades.Perro;
import com.TPfinal.veterinaria.repositorios.PerroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerroServicioDAOImpl implements PerroServicioDAO{
    @Autowired
    private final PerroRepositorio perroRepositorio;

    public PerroServicioDAOImpl(PerroRepositorio perroRepositorio) {
        this.perroRepositorio = perroRepositorio;
    }

    @Override
    public List<Perro> obtenerTodos() {
        return perroRepositorio.findAll();
    }

    @Override
    public Perro obtenerPorID(Long id) {
        return perroRepositorio.findById(id).orElse(null);
    }

    @Override
    public Perro crear(Perro perro) {
        return perroRepositorio.save(perro);
    }

    @Override
    public Perro editarPorID(Long id, Perro perro) {
        Perro perroParaEditar = perroRepositorio.findById(id).orElse(null);
        if(perroParaEditar != null){
            perroParaEditar.setEdad(perro.getEdad());
            perroParaEditar.setRaza(perro.getRaza());
            perroParaEditar.setNombre(perro.getNombre());
            perroParaEditar.setSexo(perro.getSexo());
            perroParaEditar.setLadraMucho(perro.isLadraMucho());
            perroParaEditar.setTieneGarrapatas(perro.isTieneGarrapatas());
        }
        return perroRepositorio.save(perroParaEditar);
    }

    @Override
    public void eliminarPorID(Long id) {
        perroRepositorio.deleteById(id);
    }
}
