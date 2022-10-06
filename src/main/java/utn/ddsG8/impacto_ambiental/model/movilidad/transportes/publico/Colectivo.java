package utn.ddsG8.impacto_ambiental.model.movilidad.transportes.publico;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("colectivo")
public class Colectivo extends TransportePublico {
    public Colectivo(String nombre) {
        this.nombre = nombre;
        this.paradas = new ArrayList<Parada>();
        this.nombreFE = "Colectivo";
    }
}
