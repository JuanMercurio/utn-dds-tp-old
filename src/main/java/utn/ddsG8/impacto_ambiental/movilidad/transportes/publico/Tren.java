package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import utn.ddsG8.impacto_ambiental.estructura.CalcularHC;

import java.util.ArrayList;

public class Tren extends TransportePublico {

    public Tren(String nombre) {
        this.nombre = nombre;
        this.paradas = new ArrayList<Parada>();
        this.nombreFE = "Tren";
    }


}
