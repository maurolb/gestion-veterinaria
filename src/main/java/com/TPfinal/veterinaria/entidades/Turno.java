package com.TPfinal.veterinaria.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fecha;
    private boolean disponible;
    @ManyToOne
    @JoinColumn(name="medico_id")
    private Medico medico;
    private Long mascotaID;
    private String animal;

    public Turno() {
        this.disponible = true;
        this.mascotaID = null;
        this.medico = null;
        this.animal = null;
    }

    public Turno(Long id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
        this.animal = null;
        this.disponible = true;
        this.medico = null;
        this.mascotaID = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Long getMascotaID() {
        return mascotaID;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setMascotaID(Long mascotaID) {
        this.mascotaID = mascotaID;
    }
}
