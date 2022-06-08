package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

public class Pie extends TransportePrivado {

    public Pie(Direccion inicial, Direccion fin) {
        this.inicio = inicial;
        this.fin = fin;
    }

    @Override
    public void calcularHC() {

    }
}
