package utn.ddsG8.impacto_ambiental.model.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.combustibles.Combustible;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Auto")
public class Auto extends VehiculoParticular {

    public Auto(Combustible combustible) {
        this.combustible = combustible;
        this.nombreFE = "Auto";
        // TODO: BUSCAR ..
    }

}
