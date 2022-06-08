package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;

public class Bicicleta extends TransportePrivado {

    public Bicicleta(Direccion inicial, Direccion fin) {
        this.inicio = inicial;
        this.fin = fin;
    }

    @Override
    public void calcularHC() {

    }
}
