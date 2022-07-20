package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.time.LocalDate;

public abstract class Tramo {
    protected LocalDate fecha;
    protected Distancia distancia;
    protected Transporte transporte;

    public Distancia getDistancia() {
        return this.distancia;
    }

    public Double calcularHC() {
        return transporte.calcularHC(this.distancia.valor);
    }

    public Double calcularHCAnual(int anio) {
        if (this.fecha.getYear() == anio) {
            return this.transporte.calcularHC(this.distancia.valor);
        }
        return 0.0;
    }

    public Double calcularHCMensual(int anio, int mes) {
        if (this.fecha.getMonth().getValue() == mes && this.fecha.getYear() == anio) {
            return this.transporte.calcularHC(this.distancia.valor);
        }
        return 0.0;

    }
}