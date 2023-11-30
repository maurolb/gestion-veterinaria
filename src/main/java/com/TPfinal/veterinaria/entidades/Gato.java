package com.TPfinal.veterinaria.entidades;

import jakarta.persistence.*;

@Entity
@Table(name="gatos")
public class Gato extends Mascota{
    private boolean escupePelo;
    private boolean peleaEnElTecho;

    public Gato() {
    }

    public Gato(Long id, String nombre, String raza, Boolean sexo, Integer edad, boolean escupePelo, boolean peleaEnElTecho) {
        super(id, nombre, raza, sexo, edad);
        this.escupePelo = escupePelo;
        this.peleaEnElTecho = peleaEnElTecho;
    }

    public boolean isEscupePelo() {
        return escupePelo;
    }

    public void setEscupePelo(boolean escupePelo) {
        this.escupePelo = escupePelo;
    }

    public boolean isPeleaEnElTecho() {
        return peleaEnElTecho;
    }

    public void setPeleaEnElTecho(boolean peleaEnElTecho) {
        this.peleaEnElTecho = peleaEnElTecho;
    }
}
