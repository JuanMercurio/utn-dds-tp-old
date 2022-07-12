package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.movilidad.transportes.combustibles.Combustible;

public class Moto extends VehiculoParticular {

    public Moto(Combustible combustible) {
        this.combustible = combustible;
        this.nombreFE = "Moto";
    }


}
