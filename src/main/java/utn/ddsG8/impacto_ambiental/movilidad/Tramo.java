package utn.ddsG8.impacto_ambiental.movilidad;

import lombok.Getter;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.persistence.Persistable;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import javax.persistence.*;
import java.time.LocalDate;

// TODO: Tramo es abstracta asi que hay que ver que estrategia usamos para persistir los dos tipos de tramo
//       Single table tiene bastante pinta para esta vez

@Entity
@Table
public abstract class Tramo extends Persistable {
    @Transient
    protected LocalDate fecha;

    @Getter
    @Transient
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