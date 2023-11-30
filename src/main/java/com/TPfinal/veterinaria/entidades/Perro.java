package com.TPfinal.veterinaria.entidades;

import jakarta.persistence.*;

@Entity
@Table(name="perros")
public class Perro extends Mascota{
    private boolean ladraMucho;
    private boolean tieneGarrapatas;

    public Perro() {
    }

    public Perro(Long id, String nombre, String raza, Boolean sexo, Integer edad, boolean ladraMucho, boolean tieneGarrapatas) {
        super(id, nombre, raza, sexo, edad);
        this.ladraMucho = ladraMucho;
        this.tieneGarrapatas = tieneGarrapatas;
    }

    public boolean isLadraMucho() {
        return ladraMucho;
    }

    public void setLadraMucho(boolean ladraMucho) {
        this.ladraMucho = ladraMucho;
    }

    public boolean isTieneGarrapatas() {
        return tieneGarrapatas;
    }

    public void setTieneGarrapatas(boolean tieneGarrapatas) {
        this.tieneGarrapatas = tieneGarrapatas;
    }
}
