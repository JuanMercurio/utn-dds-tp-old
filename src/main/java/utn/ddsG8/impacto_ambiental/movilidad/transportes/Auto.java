package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.CalcularHC;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.combustibles.Combustible;

public class Auto extends VehiculoParticular {


    public Auto(Combustible combustible) {
        this.combustible = combustible;
        this.nombreFE = "Auto";
        // TODO: BUSCAR ..
    }

}
