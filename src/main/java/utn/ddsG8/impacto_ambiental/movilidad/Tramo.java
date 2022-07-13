package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.time.LocalDate;

public abstract class Tramo {
    protected LocalDate fecha;
    protected Distancia distancia;

    public Distancia getDistancia() {
        return this.distancia;
    }
    public abstract Double calcularHC(CalcularHC calculador);
    public abstract Double calcularHCMensual(CalcularHC calculador, int anio, int mes);
    public abstract Double calcularHCAnual(CalcularHC calculador, int anio);
}
