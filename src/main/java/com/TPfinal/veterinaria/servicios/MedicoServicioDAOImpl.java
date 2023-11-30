package com.TPfinal.veterinaria.servicios;

import com.TPfinal.veterinaria.entidades.Medico;
import com.TPfinal.veterinaria.repositorios.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServicioDAOImpl implements MedicoServicioDAO {
    @Autowired
    private final MedicoRepositorio medicoRepositorio;

    public MedicoServicioDAOImpl(MedicoRepositorio medicoRepositorio) {
        this.medicoRepositorio = medicoRepositorio;
    }

    @Override
    public List<Medico> obtenerTodos() {
        return medicoRepositorio.findAll();
    }

    @Override
    public Medico obtenerPorID(Long id) {
        return medicoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Medico crear(Medico medico) {
        return medicoRepositorio.save(medico);
    }

    @Override
    public Medico editarPorID(Long id, Medico medico) {
        Medico medicoParaEditar = medicoRepositorio.findById(id).orElse(null);
        if(medicoParaEditar != null) {
            medicoParaEditar.setNombre(medico.getNombre());
            medicoParaEditar.setTurnos(medico.getTurnos());
        }
        return medicoRepositorio.save(medicoParaEditar);
    }

    @Override
    public void eliminarPorID(Long id) {
        medicoRepositorio.deleteById(id);
    }
}
