package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.time.LocalDate;

public abstract class Tramo {
    protected LocalDate fecha;
    protected Distancia distancia;

    public Distancia getDistancia() {
        return this.distancia;
    }

}
