package utn.ddsG8.impacto_ambiental.model.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.db.Persistable;
import utn.ddsG8.impacto_ambiental.model.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.combustibles.Combustible;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "tranporte_privado")
public abstract class TransportePrivado extends Persistable implements Transporte {

    @Column
    protected String nombreFE;
    @Transient
    protected Combustible combustible;

    public double calcularHC( double distancia) {
        double fe;
        fe = (double) CalcularHC.getInstancia().buscarFactorEmision(this.nombreFE,"");
        if (fe != -1){
            return fe * distancia;
        }
        return -1;
    }

    public String getNombre() {
        return nombreFE;
    }

    public void setNombre(String nombre) {
        this.nombreFE = nombre;
    }
}
