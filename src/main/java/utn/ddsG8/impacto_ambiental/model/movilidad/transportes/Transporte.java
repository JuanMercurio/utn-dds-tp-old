package utn.ddsG8.impacto_ambiental.model.movilidad.transportes;


import utn.ddsG8.impacto_ambiental.db.Persistable;

import javax.persistence.*;

/*
*  Se uso single table porque es la mas performante,
*  al ser un dominio pequeño no es necesario usar las otras
* */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Transporte extends Persistable {

    @Column(name = "nombreFE")
    protected String nombreFE;

    public abstract double calcularHC(double distancia);
}
