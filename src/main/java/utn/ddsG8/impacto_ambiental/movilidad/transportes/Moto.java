package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.combustibles.Combustible;

public class Moto extends VehiculoParticular {

    public Moto(String token, Direccion inicio, Direccion fin, Combustible combustible) {
        this.inicio = inicio;
        this.fin = fin;
        this.combustible = combustible;
        this.token = token;
    }

    @Override
    public void calcularHC() {

    }
}
