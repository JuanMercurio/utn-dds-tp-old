package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import java.util.ArrayList;

public class Tren extends TransportePublico {

    public Tren(String nombre) {
        this.paradas = new ArrayList<Parada>();
    }
}
