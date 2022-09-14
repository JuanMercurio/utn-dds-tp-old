package utn.ddsG8.impacto_ambiental.model.movilidad;

import lombok.Getter;
import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.db.Persistable;
import utn.ddsG8.impacto_ambiental.model.services.distancia.Distancia;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tramo")
public abstract class Tramo extends Persistable {
    @Transient
    protected LocalDate fecha;

    @Getter
    @Transient // TODO: Ver si conviene usar un float/double
    protected Distancia distancia;

    @Transient // TODO: Decidir que tipo de estrategia de herencia para persistir el transporte
    protected Transporte transporte;

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