package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.movilidad.transportes.combustibles.Combustible;

public class Camioneta extends VehiculoParticular {

    public Camioneta(Combustible combustible) {
        this.combustible = combustible;
    }

    @Override
    public void calcularHC() {

    }
}
