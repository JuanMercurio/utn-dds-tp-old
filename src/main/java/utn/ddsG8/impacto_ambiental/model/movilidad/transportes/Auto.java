package utn.ddsG8.impacto_ambiental.model.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.combustibles.Combustible;

public class Auto extends VehiculoParticular {


    public Auto(Combustible combustible) {
        this.combustible = combustible;
        this.nombreFE = "Auto";
        // TODO: BUSCAR ..
    }

}
