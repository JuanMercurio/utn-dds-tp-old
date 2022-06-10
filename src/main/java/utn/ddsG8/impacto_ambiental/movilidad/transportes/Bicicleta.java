package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;

public class Bicicleta extends TransportePrivado {

    public Bicicleta(String token, Direccion inicial, Direccion fin) {
        this.inicio = inicial;
        this.fin = fin;
        this.token = token;
    }

    @Override
    public void calcularHC() {

    }
}
