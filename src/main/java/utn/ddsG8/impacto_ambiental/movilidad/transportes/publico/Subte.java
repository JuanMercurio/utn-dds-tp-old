package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import java.util.ArrayList;

public class Subte extends TransportePublico {
    public Subte(String nombre) {
        super.nombre = nombre;
        this.paradas = new ArrayList<>();
    }

    @Override
    public void calcularHC() {
    }
}
