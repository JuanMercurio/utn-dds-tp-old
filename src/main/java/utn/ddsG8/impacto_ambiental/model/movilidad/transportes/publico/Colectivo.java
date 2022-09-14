package utn.ddsG8.impacto_ambiental.model.movilidad.transportes.publico;

import java.util.ArrayList;

public class Colectivo extends TransportePublico {
    public Colectivo(String nombre) {
        this.nombre = nombre;
        this.paradas = new ArrayList<Parada>();
        this.nombreFE = "Colectivo";
    }


}
