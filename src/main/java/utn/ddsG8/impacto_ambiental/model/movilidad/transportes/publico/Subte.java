package utn.ddsG8.impacto_ambiental.model.movilidad.transportes.publico;

import java.util.ArrayList;

public class Subte extends TransportePublico {
    public Subte(String nombre) {
        this.nombre = nombre;
        this.paradas = new ArrayList<>();
        this.nombreFE = "Subte";
    }



}
