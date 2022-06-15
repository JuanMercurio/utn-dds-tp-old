package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import java.util.ArrayList;

public class Colectivo extends TransportePublico {
    public Colectivo() {
        this.paradas = new ArrayList<Parada>();
    }

    @Override
    public void calcularHC() {

    }
}
